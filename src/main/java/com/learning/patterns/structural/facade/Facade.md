# Facade Pattern

## 🔍 Definition

**Facade** is a structural design pattern that provides a simplified interface to a library, a framework, or any other complex set of classes.

## 🧩 The Problem

Your code needs to work with a complex Video Conversion library. It requires initializing `Codec`, `BitrateReader`, `AudioMixer`, `Buffer`, etc., in the correct order. Your business logic becomes littered with these low-level calls. If the library changes, your code breaks.

## 💡 The Solution

Create a facade class (`VideoConverter`) that creates a simple entry point: `convert(filename, format)`. The facade handles the initialization and ordering of subclasses internally. The client only sees the simple method.

## 🏗️ Real-World Analogy

**Ordering Pizza by Phone**: You call the pizza shop (Facade). You say "One Pepperoni please".
You **don't** have to: call the dough guy, then the sauce guy, then the cheese guy, then the oven guy. The phone operator coordinates all that for you.

## 💻 Code Snippet

```java
public class VideoConversionFacade {
    public File convert(String fileName, String format) {
        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        // ... complex logic hidden ...
        return result;
    }
}
```

## ✅ Applicability

- Use the Facade pattern when you need to have a limited but straightforward interface to a complex subsystem.
- Use the Facade when you want to structure a subsystem into layers.

## ⚖️ Pros and Cons

| Pros                                                          | Cons                                                                 |
| :------------------------------------------------------------ | :------------------------------------------------------------------- |
| You can isolate your code from the complexity of a subsystem. | A facade can become a "god object" coupled to all classes of an app. |
