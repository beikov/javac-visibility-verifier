# Reproducer for Javac issue emitting wrong invoke bytecode

Javac gets confused when compiling `b.a()` in the constructor `pkg2.Impl(pkg2.AbstractBase)`.
It emits `invokevirtual pkg2/AbstractBase.a:()Ljava/lang/String` 
instead of `invokeinterface pkg2/BaseInterface.a:()Ljava/lang/String`.

This leads to a verifier error:

```
java.lang.VerifyError: Bad access to protected data in invokevirtual
Exception Details:
  Location:
    pkg2/Impl.<init>(Lpkg2/AbstractBase;)V @5: invokevirtual
  Reason:
    Type 'pkg2/AbstractBase' (current frame, stack[0]) is not assignable to 'pkg2/Impl'
  Current Frame:
    bci: @5
    flags: { }
    locals: { 'pkg2/Impl', 'pkg2/AbstractBase' }
    stack: { 'pkg2/AbstractBase' }
  Bytecode:
    0000000: 2ab7 0001 2bb6 0007 57b1      
```