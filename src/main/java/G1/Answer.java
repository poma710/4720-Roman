package G1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Answer {
    private String userInput;
    private Integer bulls;
    private Integer cows;

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public void setBull(Integer bull) {
        this.bulls = bull;
    }

    public void setCow(Integer cow) {
        this.cows = cow;
    }

    public String getUserInput() {
        return userInput;
    }

    public Integer getBull() {
        return bulls;
    }

    public Integer getCow() {
        return cows;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "userInput='" + userInput + '\'' +
                ", bull=" + bulls +
                ", cow=" + cows +
                '}';
    }

    public Answer(String userInput, Integer bull, Integer cow) {
        this.userInput = userInput;
        this.bulls = bull;
        this.cows= cow;
        countAnswer++;
    }
}
