import whisper
import sys

def transcribe(audio_path):
    model = whisper.load_model("base")
    result = model.transcribe(audio_path)
    print(result["text"])

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python whisper_transcribe.py <audio_file>")
        sys.exit(1)
    audio_file = sys.argv[1]
    transcribe(audio_file)
