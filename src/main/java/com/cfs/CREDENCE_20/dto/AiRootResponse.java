package com.cfs.CREDENCE_20.dto;

import lombok.Data;

import java.util.List;
@Data
public class AiRootResponse {
    private List<AiChoice> choices;


    @Data
    public static class AiChoice {// inner class 1
        private AiMessage message;



        @Data
        public static class AiMessage { //inner class 2
            private String content;
        }
    }
}
