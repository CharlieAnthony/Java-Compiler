public class DemoTypeException extends RuntimeException
{

    private String msg;

    public DemoTypeException()
    {
        super();
    }

    // Error information is to be determined separately on a case-by-case basis (see below).
    public DemoTypeException(String errmsg)
    {
        msg = errmsg;
    }

    // A method to generate a report of the error as a string.
    public String report()
    {
        return msg;
    }

    // A method to produce an exception for the 'incompatible operands' error.
    public DemoTypeException returnTypeError()
    {
        msg = "Wrong return type";
        return this;
    }

    public DemoTypeException duplicatedVarError()
    {
        msg = "Attempted to define a variable that has already been defined";
        return this;
    }

    public DemoTypeException undefinedVarError()
    {
        msg = "Attempted to use an undefined variable";
        return this;
    }

    public DemoTypeException assignError()
    {
        msg = "Attempted to assign a non-INT value to a variable";
        return this;
    }

    public DemoTypeException incompatibleOperandsError()
    {
        msg = "Attempted to use incompatible operands with a binary operator";
        return this;
    }

    public DemoTypeException condError()
    {
        msg = "Attempted to use an INT expression as a condition";
        return this;
    }


}
