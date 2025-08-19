package com.contactmanager.configuration;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;
// DEFAULT CODE - DO NOT CHANGE ANYTHING BELOW THIS LINE
@Configuration
public class H2ServerConfiguration {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
//        System.out.println("TCP SERVER");
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9876");
    }
}
// DEFAULT CODE - DO NOT CHANGE ANYTHING ABOVE THIS LINE
