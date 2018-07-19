package fileProcessors.models;
import java.util.*;

public class Chapter {
   private ArrayList<Paragraph> paragraphs;

   public Chapter() {
   	  paragraphs = new ArrayList<Paragraph>();
   }

   public void addParagraph(Paragraph paragraph) {
   	  paragraphs.add(paragraph);
   }
}