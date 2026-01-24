package org.tron.core.services.jsonrpc.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.crypto.ECKey;
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
   *
   * <p>Method under test: {@link CallArguments#getContractType(Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Transaction.Contract.ContractType CallArguments.getContractType(Wallet)"})
  public void testGetContractType()
      throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments callArguments =
        new CallArguments("", "", "Gas", "Gas Price", "not empty", "", "Nonce");

    // Act and Assert
    assertThrows(
        JsonRpcInvalidRequestException.class, () -> callArguments.getContractType(new Wallet()));
  }

  /**
   * Test {@link CallArguments#getContractType(Wallet)}.
   *
   * <p>Method under test: {@link CallArguments#getContractType(Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Transaction.Contract.ContractType CallArguments.getContractType(Wallet)"})
  public void testGetContractType2()
      throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments callArguments =
        new CallArguments("0x", "", "Gas", "Gas Price", "not empty", "", "Nonce");

    // Act and Assert
    assertThrows(
        JsonRpcInvalidRequestException.class, () -> callArguments.getContractType(new Wallet()));
  }

  /**
   * Test {@link CallArguments#getContractType(Wallet)}.
   *
   * <p>Method under test: {@link CallArguments#getContractType(Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Transaction.Contract.ContractType CallArguments.getContractType(Wallet)"})
  public void testGetContractType3()
      throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments callArguments =
        new CallArguments(null, "", "Gas", "Gas Price", "not empty", "", "Nonce");

    // Act and Assert
    assertThrows(
        JsonRpcInvalidRequestException.class, () -> callArguments.getContractType(new Wallet()));
  }

  /**
   * Test {@link CallArguments#getContractType(Wallet)}.
   *
   * <ul>
   *   <li>Given {@link CallArguments#CallArguments()}.
   *   <li>Then throw {@link JsonRpcInvalidRequestException}.
   * </ul>
   *
   * <p>Method under test: {@link CallArguments#getContractType(Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Transaction.Contract.ContractType CallArguments.getContractType(Wallet)"})
  public void testGetContractType_givenCallArguments_thenThrowJsonRpcInvalidRequestException()
      throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments callArguments = new CallArguments();

    // Act and Assert
    assertThrows(
        JsonRpcInvalidRequestException.class, () -> callArguments.getContractType(new Wallet()));
  }

  /**
   * Test {@link CallArguments#getContractType(Wallet)}.
   *
   * <ul>
   *   <li>Then {@link Wallet#Wallet()} CryptoEngine {@link ECKey}.
   * </ul>
   *
   * <p>Method under test: {@link CallArguments#getContractType(Wallet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Transaction.Contract.ContractType CallArguments.getContractType(Wallet)"})
  public void testGetContractType_thenWalletCryptoEngineECKey()
      throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments callArguments =
        new CallArguments("jane.doe@example.org", "0x", "Gas", "Gas Price", "42", "Data", "Nonce");
    Wallet wallet = new Wallet();

    // Act
    ContractType actualContractType = callArguments.getContractType(wallet);

    // Assert
    assertTrue(wallet.getCryptoEngine() instanceof ECKey);
    assertEquals(ContractType.CreateSmartContract, actualContractType);
  }

  /**
   * Test {@link CallArguments#parseValue()}.
   *
   * <p>Method under test: {@link CallArguments#parseValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long CallArguments.parseValue()"})
  public void testParseValue() throws JsonRpcInvalidParamsException {
    // Arrange
    CallArguments callArguments =
        new CallArguments(
            "jane.doe@example.org",
            "alice.liddell@example.org",
            "Gas",
            "Gas Price",
            "",
            "Data",
            "Nonce");

    // Act and Assert
    assertEquals(0L, callArguments.parseValue());
  }

  /**
   * Test {@link CallArguments#parseValue()}.
   *
   * <p>Method under test: {@link CallArguments#parseValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long CallArguments.parseValue()"})
  public void testParseValue2() throws JsonRpcInvalidParamsException {
    // Arrange
    CallArguments callArguments =
        new CallArguments(
            "jane.doe@example.org",
            "alice.liddell@example.org",
            "Gas",
            "Gas Price",
            null,
            "Data",
            "Nonce");

    // Act and Assert
    assertEquals(0L, callArguments.parseValue());
  }

  /**
   * Test {@link CallArguments#parseValue()}.
   *
   * <p>Method under test: {@link CallArguments#parseValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long CallArguments.parseValue()"})
  public void testParseValue3() throws JsonRpcInvalidParamsException {
    // Arrange
    CallArguments callArguments =
        new CallArguments(
            "jane.doe@example.org",
            "alice.liddell@example.org",
            "Gas",
            "Gas Price",
            "0x0000000000000000000000000000000000000000",
            "Data",
            "Nonce");

    // Act and Assert
    assertEquals(0L, callArguments.parseValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CallArguments.<init>()",
    "void CallArguments.<init>(String, String, String, String, String, String, String)",
    "String CallArguments.getData()",
    "String CallArguments.getFrom()",
    "String CallArguments.getGas()",
    "String CallArguments.getGasPrice()",
    "String CallArguments.getNonce()",
    "String CallArguments.getTo()",
    "String CallArguments.getValue()",
    "void CallArguments.setData(String)",
    "void CallArguments.setFrom(String)",
    "void CallArguments.setGas(String)",
    "void CallArguments.setGasPrice(String)",
    "void CallArguments.setNonce(String)",
    "void CallArguments.setTo(String)",
    "void CallArguments.setValue(String)",
    "String CallArguments.toString()"
  })
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
    assertEquals(
        "CallArguments(from=jane.doe@example.org, to=alice.liddell@example.org, gas=Gas, gasPrice=Gas Price,"
            + " value=42, data=Data, nonce=Nonce)",
        actualToStringResult);
    assertEquals("Data", actualData);
    assertEquals("Gas Price", actualGasPrice);
    assertEquals("Gas", actualGas);
    assertEquals("Nonce", actualNonce);
    assertEquals("alice.liddell@example.org", actualTo);
    assertEquals("jane.doe@example.org", actualFrom);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code jane.doe@example.org}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CallArguments#CallArguments(String, String, String, String, String, String,
   *       String)}
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CallArguments.<init>()",
    "void CallArguments.<init>(String, String, String, String, String, String, String)",
    "String CallArguments.getData()",
    "String CallArguments.getFrom()",
    "String CallArguments.getGas()",
    "String CallArguments.getGasPrice()",
    "String CallArguments.getNonce()",
    "String CallArguments.getTo()",
    "String CallArguments.getValue()",
    "void CallArguments.setData(String)",
    "void CallArguments.setFrom(String)",
    "void CallArguments.setGas(String)",
    "void CallArguments.setGasPrice(String)",
    "void CallArguments.setNonce(String)",
    "void CallArguments.setTo(String)",
    "void CallArguments.setValue(String)",
    "String CallArguments.toString()"
  })
  public void testGettersAndSetters_whenJaneDoeExampleOrg() {
    // Arrange and Act
    CallArguments actualCallArguments =
        new CallArguments(
            "jane.doe@example.org",
            "alice.liddell@example.org",
            "Gas",
            "Gas Price",
            "42",
            "Data",
            "Nonce");
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
    assertEquals(
        "CallArguments(from=jane.doe@example.org, to=alice.liddell@example.org, gas=Gas, gasPrice=Gas Price,"
            + " value=42, data=Data, nonce=Nonce)",
        actualToStringResult);
    assertEquals("Data", actualData);
    assertEquals("Gas Price", actualGasPrice);
    assertEquals("Gas", actualGas);
    assertEquals("Nonce", actualNonce);
    assertEquals("alice.liddell@example.org", actualTo);
    assertEquals("jane.doe@example.org", actualFrom);
  }
}
