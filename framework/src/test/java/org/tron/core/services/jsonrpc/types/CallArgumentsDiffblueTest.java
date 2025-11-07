package org.tron.core.services.jsonrpc.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tron.core.Wallet;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.exception.JsonRpcInvalidRequestException;

@ContextConfiguration(classes = {CallArguments.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CallArgumentsDiffblueTest {
  @Autowired
  private CallArguments callArguments;

  /**
   * Method under test: {@link CallArguments#getContractType(Wallet)}
   */
  @Test
  public void testGetContractType() throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> callArguments.getContractType(new Wallet()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CallArguments#CallArguments()}
   *   <li>{@link CallArguments#setData(String)}
   *   <li>{@link CallArguments#setFrom(String)}
   *   <li>{@link CallArguments#setGas(String)}
   *   <li>{@link CallArguments#setGasPrice(String)}
   *   <li>{@link CallArguments#setNonce(String)}
   *   <li>{@link CallArguments#setTo(String)}
   *   <li>{@link CallArguments#setValue(String)}
   *   <li>{@link CallArguments#toString()}
   *   <li>{@link CallArguments#getData()}
   *   <li>{@link CallArguments#getFrom()}
   *   <li>{@link CallArguments#getGas()}
   *   <li>{@link CallArguments#getGasPrice()}
   *   <li>{@link CallArguments#getNonce()}
   *   <li>{@link CallArguments#getTo()}
   *   <li>{@link CallArguments#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CallArguments actualCallArguments = new CallArguments();
    actualCallArguments.setData("Data");
    actualCallArguments.setFrom("jane.doe@example.org");
    actualCallArguments.setGas("Gas");
    actualCallArguments.setGasPrice("Gas Price");
    actualCallArguments.setNonce("Nonce");
    actualCallArguments.setTo("alice.liddell@example.org");
    actualCallArguments.setValue("42");
    String actualToStringResult = actualCallArguments.toString();
    String actualData = actualCallArguments.getData();
    String actualFrom = actualCallArguments.getFrom();
    String actualGas = actualCallArguments.getGas();
    String actualGasPrice = actualCallArguments.getGasPrice();
    String actualNonce = actualCallArguments.getNonce();
    String actualTo = actualCallArguments.getTo();

    // Assert that nothing has changed
    assertEquals("42", actualCallArguments.getValue());
    assertEquals("CallArguments(from=jane.doe@example.org, to=alice.liddell@example.org, gas=Gas, gasPrice=Gas Price,"
        + " value=42, data=Data, nonce=Nonce)", actualToStringResult);
    assertEquals("Data", actualData);
    assertEquals("Gas Price", actualGasPrice);
    assertEquals("Gas", actualGas);
    assertEquals("Nonce", actualNonce);
    assertEquals("alice.liddell@example.org", actualTo);
    assertEquals("jane.doe@example.org", actualFrom);
  }

  /**
   * Method under test: {@link CallArguments#parseValue()}
   */
  @Test
  public void testParseValue() throws JsonRpcInvalidParamsException {
    // Arrange
    CallArguments callArguments = new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
        "Gas Price", "42", "Data", "Nonce");
    callArguments.setValue(null);

    // Act and Assert
    assertEquals(0L, callArguments.parseValue());
  }

  /**
   * Method under test: {@link CallArguments#parseValue()}
   */
  @Test
  public void testParseValue2() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(0L, (new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas", "Gas Price", "",
        "Data", "Nonce")).parseValue());
  }

  /**
   * Method under test: {@link CallArguments#parseValue()}
   */
  @Test
  public void testParseValue3() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(0L, (new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas", "Gas Price",
        "0x0000000000000000000000000000000000000000", "Data", "Nonce")).parseValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CallArguments#CallArguments(String, String, String, String, String, String, String)}
   *   <li>{@link CallArguments#setData(String)}
   *   <li>{@link CallArguments#setFrom(String)}
   *   <li>{@link CallArguments#setGas(String)}
   *   <li>{@link CallArguments#setGasPrice(String)}
   *   <li>{@link CallArguments#setNonce(String)}
   *   <li>{@link CallArguments#setTo(String)}
   *   <li>{@link CallArguments#setValue(String)}
   *   <li>{@link CallArguments#toString()}
   *   <li>{@link CallArguments#getData()}
   *   <li>{@link CallArguments#getFrom()}
   *   <li>{@link CallArguments#getGas()}
   *   <li>{@link CallArguments#getGasPrice()}
   *   <li>{@link CallArguments#getNonce()}
   *   <li>{@link CallArguments#getTo()}
   *   <li>{@link CallArguments#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    CallArguments actualCallArguments = new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
        "Gas Price", "42", "Data", "Nonce");
    actualCallArguments.setData("Data");
    actualCallArguments.setFrom("jane.doe@example.org");
    actualCallArguments.setGas("Gas");
    actualCallArguments.setGasPrice("Gas Price");
    actualCallArguments.setNonce("Nonce");
    actualCallArguments.setTo("alice.liddell@example.org");
    actualCallArguments.setValue("42");
    String actualToStringResult = actualCallArguments.toString();
    String actualData = actualCallArguments.getData();
    String actualFrom = actualCallArguments.getFrom();
    String actualGas = actualCallArguments.getGas();
    String actualGasPrice = actualCallArguments.getGasPrice();
    String actualNonce = actualCallArguments.getNonce();
    String actualTo = actualCallArguments.getTo();

    // Assert that nothing has changed
    assertEquals("42", actualCallArguments.getValue());
    assertEquals("CallArguments(from=jane.doe@example.org, to=alice.liddell@example.org, gas=Gas, gasPrice=Gas Price,"
        + " value=42, data=Data, nonce=Nonce)", actualToStringResult);
    assertEquals("Data", actualData);
    assertEquals("Gas Price", actualGasPrice);
    assertEquals("Gas", actualGas);
    assertEquals("Nonce", actualNonce);
    assertEquals("alice.liddell@example.org", actualTo);
    assertEquals("jane.doe@example.org", actualFrom);
  }
}
