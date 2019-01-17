Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/trusty64"

  # Expose postrgres
  config.vm.network "forwarded_port", guest: 5432, host: 5432

  # Expose rabbitmq
  config.vm.network "forwarded_port", guest: 5672, host: 5672

  config.vm.provider "virtualbox" do |vb|
    vb.memory = "1024"
  end
  config.vm.provision "shell", inline: <<-SHELL
    add-apt-repository "deb https://apt.postgresql.org/pub/repos/apt/ trusty-pgdg main"
    wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | apt-key add -
    apt-get update
    apt-get upgrade -y
    apt-get install -y rabbitmq-server
    apt-get install -y postgresql-9.6

    # Make postgres listen to all interfaces
    sed /etc/postgresql/9.6/main/postgresql.conf -e "s/#listen_addresses = 'localhost'/listen_addresses = '*'/" --in-place

    # Add user and database
    su -l postgres -c "psql -c 'CREATE DATABASE webstack;'"
    su -l postgres -c "psql -c 'CREATE USER webstack WITH PASSWORD '\\''webstack'\\'';'"
    su -l postgres -c "psql -c 'GRANT CONNECT ON DATABASE webstack TO webstack;'"
    su -l postgres -c "psql -c 'GRANT USAGE ON SCHEMA public TO webstack;'"
    su -l postgres -c "psql -c 'GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO webstack;'"
    su -l postgres -c "psql -c 'GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO webstack;'"

    # Allow the vagrant host to connect with password
    if [ -z "$(cat /etc/postgresql/9.6/main/pg_hba.conf | grep '10.0.2.2')" ]; then
      echo "host    all             all             10.0.2.2/24             md5" >> /etc/postgresql/9.6/main/pg_hba.conf
    fi

    # Restart postgres
    service postgresql restart
  SHELL
end
