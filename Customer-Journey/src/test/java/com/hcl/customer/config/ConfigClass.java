package com.hcl.customer.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.hcl.customer","com.hcl.integration.customer"})
public class ConfigClass {

}
