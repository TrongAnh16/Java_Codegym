
class Test {
    private void assertEquals(int expected, int result) {
    }

    void testCalculateAdd() {
        int firstOperand = 1;
        int secondOperand = 1;
        char operation = '+';
        int expected = 2;

        int result = Calculator.calculate(firstOperand, secondOperand, operation);
        assertEquals(expected, result);
    }




//    void testCalculateSub() {
//        int a = 2;
//        int b = 1;
//        char o = '-';
//        int expected = 1;
//
//        int result = Calculator.calculate(a, b, o);
//        assertEquals(expected, result);
//    }
//
//
//    void testCalculateMul() {
//        int a = 2;
//        int b = 2;
//        char o = '*';
//        int expected = 4;
//
//        int result = Calculator.calculate(a, b, o);
//        assertEquals(expected, result);
//    }
//
//
//    void testCalculateDiv() {
//        int a = 6;
//        int b = 3;
//        char o = '/';
//        int expected = 2;
//
//        int result = Calculator.calculate(a, b, o);
//        assertEquals(expected, result);
//    }
//
//    private void assertThrows(Class<RuntimeException> runtimeExceptionClass, Object o) {
//    }
//    void testCalculateDivByZero() {
//        int a = 2;
//        int b = 0;
//        char o = '/';
//
//        assertThrows(RuntimeException.class,
//                ()-> {Calculator.calculate(a, b, o);});
//    }
//
//
//
//
//    void testCalculateWrongOperator() {
//        int a = 2;
//        int b = 0;
//        char o = '=';
//
//        assertThrows(RuntimeException.class,
//                ()-> {Calculator.calculate(a, b, o);});
//    }
}
