package study_program.problemSet.string;

import java.util.ArrayList;

public class ZigzagAWord {
    public static void main(String[] args) {
//        int n_lines = 3;
//        String word = "KICKSTART";

        String word = "INTERVIEW";
        int n_lines = 4;

        String result = zigzag(n_lines, word);
        int a = 5;
    }

    // simulate real process
    static String zigzag(Integer nlines, String word) {
        if(nlines == 1){
            return word;
        }
        int index_counter = 0;
        boolean zigzag = false;
        ArrayList<StringBuilder> character_locations = new ArrayList<>();

        for(int i = 0; i < nlines; i++){
            StringBuilder builder = new StringBuilder();
            character_locations.add(builder);
        }
        int row_index_counter = 0;

        while(index_counter < word.length()){

            if(!zigzag){// yani rowa eklenecekse
                while(row_index_counter < nlines && index_counter < word.length()){
                    StringBuilder curr_builder = character_locations.get(row_index_counter);
                    curr_builder.append(word.charAt(index_counter)); // append means sona ekle
                    row_index_counter++;
                    index_counter++;
                }
                zigzag = true;
            }else{ // yani zig zag kismindayiz
                row_index_counter = nlines - 2;
                while(row_index_counter >= 0 && index_counter < word.length()){
                    StringBuilder curr_builder = character_locations.get(row_index_counter);

                    curr_builder.append(word.charAt(index_counter)); // append means sona ekle

                    row_index_counter--;
                    index_counter++;
                }
                zigzag = false;
                row_index_counter = 1;
            }
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < character_locations.size(); i++){
            result.append(character_locations.get(i));
        }

        return result.toString();
    }
}
