package com.esand.aitasks.client;

import java.util.List;

public class GoogleRequest {

    private List<Parts> contents;

    public GoogleRequest(List<Parts> contents) {
        this.contents = contents;
    }

    public List<Parts> getContents() {
        return contents;
    }

    public void setContents(List<Parts> contents) {
        this.contents = contents;
    }

    public static class Parts {
        private List<Text> parts;

        public Parts(List<Text> parts) {
            this.parts = parts;
        }

        public List<Text> getParts() {
            return parts;
        }

        public void setParts(List<Text> parts) {
            this.parts = parts;
        }
    }

    public static class Text {
        private String text;

        public Text(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
