import OpenWay.Division;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;




//.......................................ПОЗИТИВНЫЕ ТЕСТЫ.........................................................


public class DivisionTests {
  private SoftAssert assertion = new SoftAssert();



  @Test  // Деление на  положительные числа
  public void DivDouble() {
    Double[] Num = new Double[]{1.0, 22.0, 999999999.0,+1.0, +22.0, +99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.0};
    Double[] Res = new Double[]{1.0, 0.045454545454545456, 1.000000001E-9, 1.0, 0.045454545454545456, 1.0E-89};

    for (int i = 0; i < Res.length; i++) {
      assertion.assertEquals(Division.Division(Num[i]), Res[i]);
    }
    assertion.assertAll();
  }

  @Test  // Деление на  отрицательные числа
  public void DivMinus() {
    Double[] NumMinus = new Double[]{-1.0, -22.0, -9999999999999999999999999999999999999999999999999999999999999999999.0};
    Double[] ResMinus = new Double[]{-1.0, -0.045454545454545456, -1.0E-67};

    for (int i = 0; i < ResMinus.length; i++) {
      assertion.assertEquals(Division.Division(NumMinus[i]), ResMinus[i]);
    }
    assertion.assertAll();
  }

  @Test  // Деление на целые числа  (+ и -)
  public void DivFractional() {
    Integer[] Num = new Integer[]{1, 22, 999999999, -1, -22, -999999999};
    Double[] Res = new Double[]{1.0, 0.045454545454545456, 1.000000001E-9, -1.0, -0.045454545454545456, -1.000000001E-9};

    for (int i = 0; i < Res.length; i++) {
      assertion.assertEquals(Division.Division(Double.valueOf(Num[i])), Res[i]);
    }
    assertion.assertAll();
  }

  @Test   // Деление на ноль
  public void DivZero() {
    double x = 0;
   assertion.assertEquals(Double.isInfinite(Division.Division(x)), true, "Ошибка деления на ноль");
  }

  //.......................................НЕГАТИВНЫЕ ТЕСТЫ.........................................................



/////Необходимо перехватывать иключения в случае ввода невернных значений/////////////////////////////////////////////

  @Test // ввод неверного значения (текста)
  public  void DivWrongValue(){

    String [] WrongValues = new String[]{"sdf", " ", "/1", "апова", "*1", "--1" };
    for (int i = 0; i < WrongValues.length; i++){
      boolean y = false;
    try{ Double x = new Double(WrongValues[i]);
      Division.Division(x);
    }
    catch (NumberFormatException e){
      y = true;
    }
    assertion.assertEquals( y, true);
    }
    assertion.assertAll();
  }




}


















