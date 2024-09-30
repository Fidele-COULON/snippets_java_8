package fr.fidtec.asciiart;

public enum AsciiArtFont {
	
	ART_FONT_DIALOG("Dialog"),
	ART_FONT_DIALOG_INPUT("DialogInput"), 
    ART_FONT_MONO("Monospaced"),
    ART_FONT_SERIF("Serif"),
    ART_FONT_SANS_SERIF("SansSerif");

    private String value;

    public String getValue() {
        return value;
    }

    private AsciiArtFont(String value) {
        this.value = value;
    }
}
