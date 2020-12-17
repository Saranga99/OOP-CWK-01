import java.io.Serializable;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(String date) throws InvalidDayException {
        int month = Integer.parseInt(date.substring(3, 5));
        int day = Integer.parseInt(date.substring(0, 2));
        if (month == 2) {
            if (day > 0 && day <= 29) {
                this.day = day;
            } else {
                throw new InvalidDayException();
            }
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day > 0 && day <= 31) {
                this.day = day;
            } else {
                throw new InvalidDayException();
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 0 && day < 31) {
                this.day = day;
            } else {
                throw new InvalidDayException();
            }

        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(String date) throws InvalidMonthException {
        int month = Integer.parseInt(date.substring(3, 5));
        if (month > 0 && month <= 12) {
            this.month = month;
        } else {
            throw new InvalidMonthException();

        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(String date) {
        this.year = Integer.parseInt(date.substring(6, 10));

    }

    @Override
    public String toString() {
        return day + "-" + month + "-" + year;
    }


    @Override
    public boolean equals(Object o) {
        Date date = (Date) o;
        if (this.getDay() == date.getDay() && this.getMonth() == date.getMonth() && this.getYear() == date.getYear()) {
            return true;
        } else return false;


    }

}

class InvalidDayException extends Exception {
}

class InvalidMonthException extends Exception {
}
