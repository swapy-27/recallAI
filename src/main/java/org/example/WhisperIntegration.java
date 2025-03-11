package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class WhisperIntegration {

    public  void  transcriberAudio() {
        try {
            // Path to Python executable
            String pythonPath = "C:/Program Files/Python312/";

            // Path to Whisper transcription script
            String scriptPath = "C:/Users/admin/Downloads/meeting-bot/src/main/java/org/example/WhisperIntegration.java";

            // Path to the audio file to transcribe
            String audioFilePath = "C:/Users/admin/Downloads/meeting-bot/recordings/ScreenRecording 2025-01-02 at 15.00.32.avi";

            // Build the command
            ProcessBuilder builder = new ProcessBuilder(
                    pythonPath,
                    scriptPath,
                    audioFilePath
            );

//            // Set working directory (optional)
//            builder.directory(new File("path/to/working/directory"));

            // Start the process
            Process process = builder.start();

            // Capture output from the Python script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            System.out.println("Transcription Output:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Python script exited with code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
