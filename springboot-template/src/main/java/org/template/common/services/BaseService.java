package org.template.common.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseService {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    protected static final Logger log = LoggerFactory.getLogger(BaseService.class);

}
