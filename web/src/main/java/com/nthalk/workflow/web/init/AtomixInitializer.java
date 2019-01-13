package com.nthalk.workflow.web.init;

import com.iodesystems.fn.Fn;
import com.nthalk.workflow.web.config.AppConfig.ClusterConfig;
import com.nthalk.workflow.web.config.AppConfig.ClusterNode;
import io.atomix.cluster.Node;
import io.atomix.cluster.discovery.BootstrapDiscoveryProvider;
import io.atomix.core.Atomix;
import io.atomix.protocols.raft.partition.RaftPartitionGroup;
import io.atomix.utils.net.Address;
import java.io.File;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtomixInitializer {

  @Bean
  public Atomix atomix(String home, ClusterConfig cluster) {

    RaftPartitionGroup system =
        RaftPartitionGroup.builder("system")
            .withNumPartitions(1)
            .withMembers(Fn.of(cluster.getNodes()).convert(ClusterNode::getId).toList())
            .withDataDirectory(new File(home + "/cluster-" + cluster.getId() + "-data"))
            .build();

    Atomix atomix =
        Atomix.builder()
            .withMemberId(cluster.getId())
            .withAddress(new Address(cluster.getHost(), cluster.getPort()))
            .withMembershipProvider(
                BootstrapDiscoveryProvider.builder()
                    .withNodes(
                        Fn.of(cluster.getNodes())
                            .convert(
                                n ->
                                    Node.builder()
                                        .withId(n.getId())
                                        .withAddress(Address.from(n.getHost(), n.getPort()))
                                        .build())
                            .toList())
                    .build())
            .withManagementGroup(system)
            .withPartitionGroups(system)
            .withShutdownHook(true)
            .build();

    atomix.start();

    return atomix;
  }
}
