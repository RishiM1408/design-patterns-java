package com.learning.patterns.structural.facade;

/**
 * Complex Subsystem 1: Video File Parser
 */
class VideoFile {
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

/**
 * Complex Subsystem 2: Codec Factory
 */
class CodecFactory {
    public static String extract(VideoFile file) {
        System.out.println("CodecFactory: extracting codec from " + file.getName());
        return "mp4";
    }
}

/**
 * Complex Subsystem 3: Bitrate Reader
 */
class BitrateReader {
    public static String read(String filename, String sourceCodec) {
        System.out.println("BitrateReader: reading file...");
        return "buffer";
    }

    public static String convert(String buffer, String destinationCodec) {
        System.out.println("BitrateReader: writing file to " + destinationCodec);
        return "video_converted." + destinationCodec;
    }
}

/**
 * Complex Subsystem 4: Audio Mixer
 */
class AudioMixer {
    public static String fix(String result) {
        System.out.println("AudioMixer: fixing audio...");
        return result;
    }
}
