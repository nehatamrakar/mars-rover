package practise;

import java.util.List;

public class Plateau {
    public int bottomLeftX = 0;
    public int bottomLeftY = 0;
    public int topRightX;
    public int topRightY;

    private List<Rover> rovers;

    public Plateau(int x, int y) {
        this.topRightX = x - 1;
        this.topRightY = y - 1;
    }

    public void addRovers(List<Rover> rovers) {
        this.rovers = rovers;
    }

    public void action(List<Rover> rovers, List<List<Instruction>> instructionsList) {
        int iterableNumber = 0;
        int stepNumber = 0;
        int maximumIterableNumber = instructionsList.size();
        int maximumStepNumber = 0;
        for (List<Instruction> instructionList : instructionsList) {
            maximumStepNumber = Math.max(maximumStepNumber, instructionList.size());
        }
        while (stepNumber < maximumStepNumber) {
            for (Rover rover : rovers) {
                if(instructionsList.get(iterableNumber).size() <= stepNumber) {
                    iterableNumber++;
                    continue;
                }
                rover.action(instructionsList.get(iterableNumber).get(stepNumber));
                iterableNumber++;
            }
            stepNumber++;
            if(iterableNumber == maximumIterableNumber) iterableNumber = 0;
        }
    }
}
