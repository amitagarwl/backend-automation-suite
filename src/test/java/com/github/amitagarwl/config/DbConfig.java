package com.github.amitagarwl.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by amit.agarwal on 6/26/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DbConfig {
     String driverClass;
     String url;
     String username;
     String password;
}
