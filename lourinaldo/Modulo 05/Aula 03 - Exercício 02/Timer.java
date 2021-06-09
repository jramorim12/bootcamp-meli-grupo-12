import java.util.Date;

public class Timer {
    private Date startTime;
    private Date endTime;

    public Timer() {
    }

    public void start(){
        setStartTime(new Date());
    }

    public void stop(){
        setEndTime(new Date());
    }

    public long elapsedTime(){
        long timeMilli = this.getEndTime().getTime() - this.getStartTime().getTime();
        return timeMilli;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
