package calculator.expression;


public class Number extends Expression {

    private Number(final String numberString) {
        validate(numberString);

        this.operand = Integer.parseInt(numberString);
    }

    public static Number of(final String numberString) {
        return new Number(numberString);
    }

    @Override
    public int operate() {
        return operand;
    }

    private void validate(String numberString) {
        if(numberString == null || numberString.isEmpty()) {
            throw new IllegalArgumentException("Number string is null or empty");
        }
    }
}
