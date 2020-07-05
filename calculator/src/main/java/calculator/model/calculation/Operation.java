package calculator.model.calculation;

public enum Operation
{

    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    private String symbol;

    private Operation(final String symbol)
    {
        this.symbol = symbol;
    }

    public String getSymbol()
    {
        return symbol;
    }

}
