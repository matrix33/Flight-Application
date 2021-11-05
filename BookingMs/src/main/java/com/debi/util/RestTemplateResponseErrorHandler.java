package com.debi.util;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;

import com.debi.exception.BsnsObjException;

public class RestTemplateResponseErrorHandler extends DefaultResponseErrorHandler {

	@Override
    public boolean hasError(ClientHttpResponse httpResponse)
        throws IOException {

        return (httpResponse
          .getStatusCode()
          .series() == HttpStatus.Series.CLIENT_ERROR || httpResponse
          .getStatusCode()
          .series() == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse)
        throws IOException {

        if (httpResponse
          .getStatusCode()
          .series() == HttpStatus.Series.SERVER_ERROR) {
            //Handle SERVER_ERROR
            throw new HttpClientErrorException(httpResponse.getStatusCode());
        } else if (httpResponse
          .getStatusCode()
          .series() == HttpStatus.Series.CLIENT_ERROR) {
            //Handle CLIENT_ERROR
        	throw new BsnsObjException(httpResponse.getBody().toString(), httpResponse.getStatusCode());
//            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
//                throw new BsnsObjException(httpResponse.getBody().toString());
//            }
        }
    }

}
