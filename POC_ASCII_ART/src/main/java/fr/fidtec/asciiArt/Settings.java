package fr.fidtec.asciiArt;

import java.awt.Font;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Settings {
  private Font font;
  private int width;
  private int height;
}
