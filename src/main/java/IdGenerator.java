import java.util.Calendar;

public class IdGenerator {
    private  int year;
    private  int count;

    public IdGenerator() {
    }

    public IdGenerator(int count){
        this.count = count;
        reset();
    }

    private void setYear(int year){
        this.year = year;
    }


    public void reset() {
        Calendar cal = Calendar.getInstance();
        if (getYear() > year) {
            //setCounter(1);
            setYear(getYear());
        }
    }

    public int getYear() {
        Calendar cal = Calendar.getInstance();
        return  cal.get(Calendar.YEAR);
    }

    public String generateID() {
        // reset();
        String year = String.valueOf(this.year);
        String count = String.valueOf(this.count);
        if (count.length() != 5) {
            for (int i = count.length(); count.length() <= 3; i++)
                count = '0' + count;
        }
        String id = year + count;
        //setCounter(getCounter()+1);

        return id;

    }




}
