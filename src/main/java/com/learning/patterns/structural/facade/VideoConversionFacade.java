package com.learning.patterns.structural.facade;

/**
 * The Facade.
 * Provides a simple interface for converting videos, hiding the complexity of
 * the subsystems.
 */
public class VideoConversionFacade {
    public String convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");

        VideoFile file = new VideoFile(fileName);
        String sourceCodec = CodecFactory.extract(file);

        String buffer = BitrateReader.read(fileName, sourceCodec);
        String result = BitrateReader.convert(buffer, format);

        result = AudioMixer.fix(result);

        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}
