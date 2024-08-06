package org.mifos.connector.airtel.api.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mifos.connector.common.mobilemoney.airtel.dto.AirtelCallBackRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CallBackController {

    @Autowired
    ObjectMapper objectMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ResponseEntity<AirtelCallBackRequestDTO> handleCallBackRequest(AirtelCallBackRequestDTO requestBody) {
        try {
            logger.info("CallBack Request: {}", objectMapper.writeValueAsString(requestBody));
            return ResponseEntity.status(HttpStatus.OK).body(requestBody);
        } catch (Exception ex) {
            throw new RuntimeException("Invalid response!", ex);
        }
    }
}
