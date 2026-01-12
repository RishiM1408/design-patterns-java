package com.learning.patterns.structural.facade;

/**
 * Client Demo for Facade Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Facade Pattern Demo ---");

        // The client doesn't need to know about CodecFactory, BitrateReader, etc.
        VideoConversionFacade converter = new VideoConversionFacade();

        String mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");

        System.out.println("Result: " + mp4Video);
    }
}
