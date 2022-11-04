package com.backinfile.support.func;

import com.backinfile.support.SysException;

public class CommonFunction {
    private final int argNum;
    private final Object func;

    public CommonFunction(int argNum, Object func) {
        this.argNum = argNum;
        this.func = func;
    }

    @SuppressWarnings("all")
    public Object invoke(Object... args) {
        switch (argNum) {
            case 0:
                return ((Function0) func).invoke();
            case 1:
                return ((Function1) func).invoke(args[0]);
            case 2:
                return ((Function2) func).invoke(args[0], args[1]);
            case 3:
                return ((Function3) func).invoke(args[0], args[1], args[2]);
            case 4:
                return ((Function4) func).invoke(args[0], args[1], args[2], args[3]);
            case 5:
                return ((Function5) func).invoke(args[0], args[1], args[2], args[3], args[4]);
            case 6:
                return ((Function6) func).invoke(args[0], args[1], args[2], args[3], args[4], args[5]);
            case 7:
                return ((Function7) func).invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
            case 8:
                return ((Function8) func).invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
        }
        throw new SysException("argNum not march");
    }

    @SuppressWarnings("all")
    public Object invoke(Object firstArg, Object[] args) {
        switch (argNum) {
            case 0:
                return ((Function0) func).invoke();
            case 1:
                return ((Function1) func).invoke(firstArg);
            case 2:
                return ((Function2) func).invoke(firstArg, args[0]);
            case 3:
                return ((Function3) func).invoke(firstArg, args[0], args[1]);
            case 4:
                return ((Function4) func).invoke(firstArg, args[0], args[1], args[2]);
            case 5:
                return ((Function5) func).invoke(firstArg, args[0], args[1], args[2], args[3]);
            case 6:
                return ((Function6) func).invoke(firstArg, args[0], args[1], args[2], args[3], args[4]);
            case 7:
                return ((Function7) func).invoke(firstArg, args[0], args[1], args[2], args[3], args[4], args[5]);
            case 8:
                return ((Function8) func).invoke(firstArg, args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
        }
        throw new SysException("argNum not march");
    }
}
