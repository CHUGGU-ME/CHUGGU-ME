package com.chuggume.chuggume.service

import com.chuggume.chuggume.logger
import org.springframework.stereotype.Service

@Service
class MomService {

    private val log = logger()

    public fun service(){
        log.info("무야호!")
    }
}