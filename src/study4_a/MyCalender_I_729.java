package study4_a;

import java.util.ArrayList;
import java.util.List;

public class MyCalender_I_729 {
    // since writing tests will take time, go to official site.
    class MyCalendar {
        class Book{
            int start;
            int end;

            public Book(int start, int end){
                this.start = start;
                this.end = end;
            }

            public int compareTo(Object other){
                Book otherBook = (Book)other;

                if(this.start < otherBook.start){
                    return 1;
                }else if(this.start == otherBook.start){
                    if(this.end < otherBook.end){
                        return 0;
                    }
                    return 1;
                }
                return 0;
            }
        }

        List<Book> bookList;

        public MyCalendar() {
            bookList = new ArrayList<>();
        }

        public boolean book(int startTime, int endTime) {
            // System.out.println("start: " + startTime + " end: " + endTime);
            Book newBook = new Book(startTime, endTime);

            if(binarySort(0, bookList.size(), newBook)){ //
                // System.out.println("don't add");
                return false;
            }

            bookList.add(newBook);
            return true;
        }

        public boolean binarySort(int startInd, int endInd, Book currBook){
            if(bookList.size() == 0){
                return false;
            }

            if(startInd < 0 || endInd < 0 || startInd > bookList.size() || endInd > bookList.size() || startInd > endInd){
                return false;
            }

            int medInd = (endInd - startInd) / 2 + startInd;
            // System.out.println("start: " + startInd + " med: " + medInd + " end: " + endInd);

            return isAlreadyBooked(medInd, currBook) || binarySort(startInd, medInd - 1, currBook) || binarySort(medInd + 1, endInd, currBook);
        }

        public boolean isAlreadyBooked(int currInd, Book currBook){
            if(currInd >= bookList.size()){
                return false;
            }
            Book currSelectedBook = bookList.get(currInd);
            // For an overlap, the old one must start before the new one ends and the new one must start before the old one ends.
            if (currSelectedBook.start < currBook.end && currBook.start < currSelectedBook.end ) {
                return true;
            }


            return false;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
}
