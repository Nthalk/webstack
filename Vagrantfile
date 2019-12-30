Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/bionic64"

  # Expose postrgres
  config.vm.network "forwarded_port", guest: 5432, host: 5432

  # Expose rabbitmq
  config.vm.network "forwarded_port", guest: 5672, host: 5672

  # Expose prometheus
  config.vm.network "forwarded_port", guest: 9090, host: 9090

  # Expose graphana
  config.vm.network "forwarded_port", guest: 3000, host: 3000

  config.vm.provider "virtualbox" do |vb|
    vb.memory = "1024"
  end
  config.vm.provision "shell", inline: <<-SHELL
    add-apt-repository "deb https://apt.postgresql.org/pub/repos/apt/ bionic-pgdg main"
    wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | apt-key add -
    apt-get update
    apt-get upgrade -y
    apt-get install -y rabbitmq-server
    apt-get install -y postgresql-11

    # Rabbit mq
    rabbitmqctl add_user rabbitmq rabbitmq
    rabbitmqctl set_permissions -p / rabbitmq ".*" ".*" ".*"

    # Prometheus
    wget https://github.com/prometheus/prometheus/releases/download/v2.12.0/prometheus-2.12.0.linux-amd64.tar.gz
    useradd -M -r -s /bin/false prometheus
    mkdir /etc/prometheus /var/lib/prometheus
    tar -xvf prometheus-2.12.0.linux-amd64.tar.gz
    cp prometheus-2.12.0.linux-amd64/{prometheus,promtool} /usr/local/bin/
    chown prometheus:prometheus /usr/local/bin/{prometheus,promtool}
    cp -r prometheus-2.12.0.linux-amd64/{consoles,console_libraries} /etc/prometheus/
    cp prometheus-2.12.0.linux-amd64/prometheus.yml /etc/prometheus/prometheus.yml
    chown -R prometheus:prometheus /etc/prometheus
    chown prometheus:prometheus /var/lib/prometheus

    cat << EOF >> /etc/systemd/system/prometheus.service
[Unit]
Description=Prometheus Time Series Collection and Processing Server
Wants=network-online.target
After=network-online.target

[Service]
User=prometheus
Group=prometheus
Type=simple
ExecStart=/usr/local/bin/prometheus \
    --config.file /etc/prometheus/prometheus.yml \
    --storage.tsdb.path /var/lib/prometheus/ \
    --web.console.templates=/etc/prometheus/consoles \
    --web.console.libraries=/etc/prometheus/console_libraries

[Install]
WantedBy=multi-user.target
EOF

    systemctl daemon-reload
    systemctl start prometheus
    systemctl enable prometheus

    # Graphana
    apt-get install -y   fontconfig-config fonts-dejavu-core libfontconfig1
    wget https://dl.grafana.com/oss/release/grafana_6.3.5_amd64.deb
    sudo dpkg -i grafana_6.3.5_amd64.deb
    update-rc.d grafana-server defaults 95 10
    systemctl enable grafana-server
    systemctl start grafana-server

    # Make postgres listen to all interfaces
    sed /etc/postgresql/11/main/postgresql.conf -e "s/#listen_addresses = 'localhost'/listen_addresses = '*'/" --in-place

    # Allow the vagrant host to connect with password
    if [ -z "$(cat /etc/postgresql/11/main/pg_hba.conf | grep '10.0.2.2')" ]; then
      echo "host    all             all             10.0.2.2/24             md5" >> /etc/postgresql/11/main/pg_hba.conf
    fi

    # Restart postgres
    service postgresql restart
  SHELL
end
