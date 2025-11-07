package org.tron.core.services.jsonrpc.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.Wallet;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.exception.JsonRpcInvalidRequestException;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Contract;
import org.tron.protos.Protocol.Transaction.Contract.ContractType;

public class CallArgumentsDiffblueTest {
  /**
   * Test {@link CallArguments#getContractType(Wallet)}.
   * <p>
   * Method under test: {@link CallArguments#getContractType(Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Transaction.Contract.ContractType CallArguments.getContractType(Wallet)"})
  public void testGetContractType() throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments callArguments = new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
        "Gas Price", "42", "Data", "Nonce");
    callArguments.setTo("0x");
    callArguments.setData("0x");
    callArguments.setFrom("0x");
    callArguments.setValue(null);

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> callArguments.getContractType(new Wallet()));
  }

  /**
   * Test {@link CallArguments#getContractType(Wallet)}.
   * <p>
   * Method under test: {@link CallArguments#getContractType(Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Transaction.Contract.ContractType CallArguments.getContractType(Wallet)"})
  public void testGetContractType2() throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments callArguments = new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
        "Gas Price", "42", "Data", "Nonce");
    callArguments.setTo("0x");
    callArguments.setData("0x");
    callArguments.setFrom(null);
    callArguments.setValue(null);

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> callArguments.getContractType(new Wallet()));
  }

  /**
   * Test {@link CallArguments#getContractType(Wallet)}.
   * <p>
   * Method under test: {@link CallArguments#getContractType(Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Transaction.Contract.ContractType CallArguments.getContractType(Wallet)"})
  public void testGetContractType3() throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments callArguments = new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
        "Gas Price", "42", "Data", "Nonce");
    callArguments.setTo("0x");
    callArguments.setData("0x");
    callArguments.setFrom("foo");
    callArguments.setValue(null);

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> callArguments.getContractType(new Wallet()));
  }

  /**
   * Test {@link CallArguments#getContractType(Wallet)}.
   * <p>
   * Method under test: {@link CallArguments#getContractType(Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Transaction.Contract.ContractType CallArguments.getContractType(Wallet)"})
  public void testGetContractType4() throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments callArguments = new CallArguments("", "alice.liddell@example.org", "Gas", "Gas Price", "42", "Data",
        "Nonce");

    // Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> callArguments.getContractType(new Wallet()));
  }

  /**
   * Test {@link CallArguments#getContractType(Wallet)}.
   * <ul>
   *   <li>Then return {@code CreateSmartContract}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CallArguments#getContractType(Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Transaction.Contract.ContractType CallArguments.getContractType(Wallet)"})
  public void testGetContractType_thenReturnCreateSmartContract()
      throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments callArguments = new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
        "Gas Price", "42", "Data", "Nonce");
    callArguments.setTo("0x");
    callArguments.setData("foo");
    callArguments.setFrom("foo");
    callArguments.setValue(null);

    // Act and Assert
    assertEquals(ContractType.CreateSmartContract, callArguments.getContractType(new Wallet()));
  }

  /**
   * Test {@link CallArguments#parseValue()}.
   * <p>
   * Method under test: {@link CallArguments#parseValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long CallArguments.parseValue()"})
  public void testParseValue() throws JsonRpcInvalidParamsException {
    // Arrange
    CallArguments callArguments = new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
        "Gas Price", "42", "Data", "Nonce");
    callArguments.setValue(null);

    // Act and Assert
    assertEquals(0L, callArguments.parseValue());
  }

  /**
   * Test {@link CallArguments#parseValue()}.
   * <p>
   * Method under test: {@link CallArguments#parseValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long CallArguments.parseValue()"})
  public void testParseValue2() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(0L, (new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas", "Gas Price", "",
        "Data", "Nonce")).parseValue());
  }

  /**
   * Test {@link CallArguments#parseValue()}.
   * <p>
   * Method under test: {@link CallArguments#parseValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long CallArguments.parseValue()"})
  public void testParseValue3() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(0L, (new CallArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas", "Gas Price",
        "0x0000000000000000000000000000000000000000", "Data", "Nonce")).parseValue());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CallArguments.<init>()",
      "void CallArguments.<init>(String, String, String, String, String, String, String)",
      "String CallArguments.getData()", "String CallArguments.getFrom()", "String CallArguments.getGas()",
      "String CallArguments.getGasPrice()", "String CallArguments.getNonce()", "String CallArguments.getTo()",
      "String CallArguments.getValue()", "void CallArguments.setData(String)", "void CallArguments.setFrom(String)",
      "void CallArguments.setGas(String)", "void CallArguments.setGasPrice(String)",
      "void CallArguments.setNonce(String)", "void CallArguments.setTo(String)", "void CallArguments.setValue(String)",
      "String CallArguments.toString()"})
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

    // Assert
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@code jane.doe@example.org}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CallArguments#CallArguments(String, String, String, String, String, String, String)}
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CallArguments.<init>()",
      "void CallArguments.<init>(String, String, String, String, String, String, String)",
      "String CallArguments.getData()", "String CallArguments.getFrom()", "String CallArguments.getGas()",
      "String CallArguments.getGasPrice()", "String CallArguments.getNonce()", "String CallArguments.getTo()",
      "String CallArguments.getValue()", "void CallArguments.setData(String)", "void CallArguments.setFrom(String)",
      "void CallArguments.setGas(String)", "void CallArguments.setGasPrice(String)",
      "void CallArguments.setNonce(String)", "void CallArguments.setTo(String)", "void CallArguments.setValue(String)",
      "String CallArguments.toString()"})
  public void testGettersAndSetters_whenJaneDoeExampleOrg() {
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

    // Assert
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
