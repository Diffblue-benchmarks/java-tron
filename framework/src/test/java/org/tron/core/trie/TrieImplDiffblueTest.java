package org.tron.core.trie;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.capsule.BytesCapsule;
import org.tron.core.db2.common.ConcurrentHashDB;
import org.tron.core.db2.common.DB;
import org.tron.core.trie.TrieImpl.Node;
import org.tron.core.trie.TrieImpl.NodeType;
import org.tron.core.trie.TrieImpl.ScanAction;

public class TrieImplDiffblueTest {
  /**
   * Test {@link TrieImpl#TrieImpl()}.
   * <p>
   * Method under test: {@link TrieImpl#TrieImpl()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.<init>()"})
  public void testNewTrieImpl() {
    // Arrange and Act
    TrieImpl actualTrieImpl = new TrieImpl();

    // Assert
    DB<byte[], BytesCapsule> cache = actualTrieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertNull(cache.getDbName());
    assertNull(cache.iterator());
    assertNull(actualTrieImpl.getRoot());
    assertEquals(0L, cache.size());
    assertTrue(cache.isEmpty());
    assertArrayEquals(new byte[]{'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
        -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'}, actualTrieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#TrieImpl(DB)}.
   * <p>
   * Method under test: {@link TrieImpl#TrieImpl(DB)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.<init>(DB)"})
  public void testNewTrieImpl2() {
    // Arrange
    ConcurrentHashDB cache = new ConcurrentHashDB();

    // Act
    TrieImpl actualTrieImpl = new TrieImpl(cache);

    // Assert
    assertNull(actualTrieImpl.getRoot());
    assertSame(cache, actualTrieImpl.getCache());
    assertArrayEquals(new byte[]{'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
        -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'}, actualTrieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#TrieImpl(DB, byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return RootHash is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#TrieImpl(DB, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.<init>(DB, byte[])"})
  public void testNewTrieImpl_whenAxaxaxaxBytesIsUtf8_thenReturnRootHashIsNull() throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashDB cache = new ConcurrentHashDB();

    // Act
    TrieImpl actualTrieImpl = new TrieImpl(cache, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualTrieImpl.getRootHash());
    Node root = actualTrieImpl.getRoot();
    assertNull(root.hash);
    assertNull(root.getNodeType());
    assertEquals(NodeType.BranchNode, root.getType());
  }

  /**
   * Test {@link TrieImpl#TrieImpl(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return RootHash is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#TrieImpl(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.<init>(byte[])"})
  public void testNewTrieImpl_whenAxaxaxaxBytesIsUtf8_thenReturnRootHashIsNull2() throws UnsupportedEncodingException {
    // Arrange and Act
    TrieImpl actualTrieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualTrieImpl.getRootHash());
    Node root = actualTrieImpl.getRoot();
    assertNull(root.hash);
    assertNull(root.getNodeType());
    assertEquals(NodeType.BranchNode, root.getType());
  }

  /**
   * Test {@link TrieImpl#TrieImpl(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then Cache return {@link ConcurrentHashDB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#TrieImpl(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.<init>(byte[])"})
  public void testNewTrieImpl_whenNull_thenCacheReturnConcurrentHashDB() {
    // Arrange and Act
    TrieImpl actualTrieImpl = new TrieImpl((byte[]) null);

    // Assert
    DB<byte[], BytesCapsule> cache = actualTrieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertNull(cache.getDbName());
    assertNull(cache.iterator());
    assertNull(actualTrieImpl.getRoot());
    assertEquals(0L, cache.size());
    assertTrue(cache.isEmpty());
    assertArrayEquals(new byte[]{'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
        -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'}, actualTrieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#TrieImpl(DB, byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Root is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#TrieImpl(DB, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.<init>(DB, byte[])"})
  public void testNewTrieImpl_whenNull_thenReturnRootIsNull() {
    // Arrange
    ConcurrentHashDB cache = new ConcurrentHashDB();

    // Act
    TrieImpl actualTrieImpl = new TrieImpl(cache, null);

    // Assert
    assertNull(actualTrieImpl.getRoot());
    assertSame(cache, actualTrieImpl.getCache());
    assertArrayEquals(new byte[]{'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
        -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'}, actualTrieImpl.getRootHash());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TrieImpl#setAsync(boolean)}
   *   <li>{@link TrieImpl#getCache()}
   *   <li>{@link TrieImpl#getRoot()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DB TrieImpl.getCache()", "Node TrieImpl.getRoot()", "void TrieImpl.setAsync(boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act
    trieImpl.setAsync(true);
    DB<byte[], BytesCapsule> actualCache = trieImpl.getCache();

    // Assert
    assertTrue(actualCache instanceof ConcurrentHashDB);
    assertNull(trieImpl.getRoot());
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   * <p>
   * Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualGetResult = trieImpl.get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualGetResult);
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} array of {@code byte} with {@code A} and one is array of {@code byte} with {@code A} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey_givenTrieImplArrayOfByteWithAAndOneIsArrayOfByteWithAAndOne()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualGetResult = trieImpl.get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualGetResult);
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} {@code AXAXAXAX} Bytes is {@code UTF-8} is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey_givenTrieImplAxaxaxaxBytesIsUtf8IsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualGetResult = trieImpl.get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualGetResult);
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey_givenTrieImplWithRootIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(trieImpl.get("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey_givenTrieImpl_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act and Assert
    assertNull(trieImpl.get("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   * <ul>
   *   <li>Given {@code X}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey_givenX_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(trieImpl.get("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Node {@link Node#branchNodeCanCompact()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#branchNodeCanCompact()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Node.branchNodeCanCompact()"})
  public void testNodeBranchNodeCanCompact_givenA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(((new TrieImpl()).new Node(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17})).branchNodeCanCompact());
  }

  /**
   * Test Node {@link Node#branchNodeCanCompact()}.
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#branchNodeCanCompact()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Node.branchNodeCanCompact()"})
  public void testNodeBranchNodeCanCompact_givenNodeWithThis$0IsTrieImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(((new TrieImpl()).new Node()).branchNodeCanCompact());
  }

  /**
   * Test Node {@link Node#branchNodeCompactIdx()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#branchNodeCompactIdx()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Node.branchNodeCompactIdx()"})
  public void testNodeBranchNodeCompactIdx_givenA_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1,
        ((new TrieImpl()).new Node(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17})).branchNodeCompactIdx());
  }

  /**
   * Test Node {@link Node#branchNodeCompactIdx()}.
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#branchNodeCompactIdx()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Node.branchNodeCompactIdx()"})
  public void testNodeBranchNodeCompactIdx_givenNodeWithThis$0IsTrieImpl_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, ((new TrieImpl()).new Node()).branchNodeCompactIdx());
  }

  /**
   * Test Node {@link Node#branchNodeGetChild(int)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#branchNodeGetChild(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Node.branchNodeGetChild(int)"})
  public void testNodeBranchNodeGetChild_givenA_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(((new TrieImpl()).new Node(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17})).branchNodeGetChild(1));
  }

  /**
   * Test Node {@link Node#branchNodeGetChild(int)}.
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#branchNodeGetChild(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Node.branchNodeGetChild(int)"})
  public void testNodeBranchNodeGetChild_givenNodeWithThis$0IsTrieImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(((new TrieImpl()).new Node()).branchNodeGetChild(1));
  }

  /**
   * Test Node {@link Node#branchNodeGetValue()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#branchNodeGetValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Node.branchNodeGetValue()"})
  public void testNodeBranchNodeGetValue_givenA_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(((new TrieImpl()).new Node(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17})).branchNodeGetValue());
  }

  /**
   * Test Node {@link Node#branchNodeGetValue()}.
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#branchNodeGetValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Node.branchNodeGetValue()"})
  public void testNodeBranchNodeGetValue_givenNodeWithThis$0IsTrieImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(((new TrieImpl()).new Node()).branchNodeGetValue());
  }

  /**
   * Test Node {@link Node#branchNodeSetChild(int, Node)}.
   * <p>
   * Method under test: {@link Node#branchNodeSetChild(int, Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Node.branchNodeSetChild(int, Node)"})
  public void testNodeBranchNodeSetChild() {
    // Arrange
    Node node = (new TrieImpl()).new Node(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertSame(node, node.branchNodeSetChild(1, (new TrieImpl()).new Node()));
  }

  /**
   * Test Node {@link Node#branchNodeSetChild(int, Node)}.
   * <ul>
   *   <li>Then return {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#branchNodeSetChild(int, Node)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Node.branchNodeSetChild(int, Node)"})
  public void testNodeBranchNodeSetChild_thenReturnNodeWithThis$0IsTrieImpl() {
    // Arrange
    Node node = (new TrieImpl()).new Node();

    // Act and Assert
    assertSame(node, node.branchNodeSetChild(1, (new TrieImpl()).new Node()));
  }

  /**
   * Test Node {@link Node#branchNodeSetValue(byte[])}.
   * <p>
   * Method under test: {@link Node#branchNodeSetValue(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Node.branchNodeSetValue(byte[])"})
  public void testNodeBranchNodeSetValue() throws UnsupportedEncodingException {
    // Arrange
    Node node = (new TrieImpl()).new Node(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertSame(node, node.branchNodeSetValue("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Node {@link Node#branchNodeSetValue(byte[])}.
   * <ul>
   *   <li>Then return {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#branchNodeSetValue(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Node.branchNodeSetValue(byte[])"})
  public void testNodeBranchNodeSetValue_thenReturnNodeWithThis$0IsTrieImpl() throws UnsupportedEncodingException {
    // Arrange
    Node node = (new TrieImpl()).new Node();

    // Act and Assert
    assertSame(node, node.branchNodeSetValue("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Node {@link Node#dumpStruct(String, String)}.
   * <p>
   * Method under test: {@link Node#dumpStruct(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Node.dumpStruct(String, String)"})
  public void testNodeDumpStruct() {
    // Arrange, Act and Assert
    assertEquals("IndentPrefixBranchNode\n",
        ((new TrieImpl()).new Node(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17})).dumpStruct("Indent", "Prefix"));
  }

  /**
   * Test Node {@link Node#dumpStruct(String, String)}.
   * <p>
   * Method under test: {@link Node#dumpStruct(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Node.dumpStruct(String, String)"})
  public void testNodeDumpStruct2() {
    // Arrange, Act and Assert
    assertEquals("IndentPrefixBranchNode\n",
        ((new TrieImpl()).new Node(new byte[]{Byte.MIN_VALUE, 17, 'A', 17, 'A', 17, 'A', 17})).dumpStruct("Indent",
            "Prefix"));
  }

  /**
   * Test Node {@link Node#dumpStruct(String, String)}.
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl, byte[])} with this$0 is {@link TrieImpl#TrieImpl()} and hashOrRlp is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#dumpStruct(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Node.dumpStruct(String, String)"})
  public void testNodeDumpStruct_givenNodeWithThis$0IsTrieImplAndHashOrRlpIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertEquals("IndentPrefixBranchNode\n", ((new TrieImpl()).new Node(new byte[]{})).dumpStruct("Indent", "Prefix"));
  }

  /**
   * Test Node {@link Node#dumpStruct(String, String)}.
   * <ul>
   *   <li>Then return {@code IndentPrefixBranchNode *}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#dumpStruct(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Node.dumpStruct(String, String)"})
  public void testNodeDumpStruct_thenReturnIndentPrefixBranchNode() {
    // Arrange, Act and Assert
    assertEquals("IndentPrefixBranchNode *\n", ((new TrieImpl()).new Node()).dumpStruct("Indent", "Prefix"));
  }

  /**
   * Test Node {@link Node#dumpStruct(String, String)}.
   * <ul>
   *   <li>Then return {@code IndentPrefixBranchNode * [T] = 4111411141114111}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#dumpStruct(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Node.dumpStruct(String, String)"})
  public void testNodeDumpStruct_thenReturnIndentPrefixBranchNodeT4111411141114111() {
    // Arrange
    Node node = (new TrieImpl()).new Node();
    node.branchNodeSetValue(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertEquals("IndentPrefixBranchNode * [T] = 4111411141114111\n", node.dumpStruct("Indent", "Prefix"));
  }

  /**
   * Test Node {@link Node#dumpStruct(String, String)}.
   * <ul>
   *   <li>Then return {@code IndentPrefixKVNodeNode * [null] Indent BranchNode *}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#dumpStruct(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Node.dumpStruct(String, String)"})
  public void testNodeDumpStruct_thenReturnIndentPrefixKVNodeNodeNullIndentBranchNode() {
    // Arrange
    Node node = (new TrieImpl()).new Node(3);
    node.kvNodeSetValueOrNode((new TrieImpl()).new Node());

    // Act and Assert
    assertEquals("IndentPrefixKVNodeNode * [null]\nIndent  BranchNode *\n", node.dumpStruct("Indent", "Prefix"));
  }

  /**
   * Test Node {@link Node#dumpStruct(String, String)}.
   * <ul>
   *   <li>Then return {@code IndentPrefixKVNodeValue * [null] = 4111411141114111}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#dumpStruct(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Node.dumpStruct(String, String)"})
  public void testNodeDumpStruct_thenReturnIndentPrefixKVNodeValueNull4111411141114111() {
    // Arrange
    Node node = (new TrieImpl()).new Node(3);
    node.kvNodeSetValue(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertEquals("IndentPrefixKVNodeValue * [null] = 4111411141114111\n", node.dumpStruct("Indent", "Prefix"));
  }

  /**
   * Test Node {@link Node#dumpTrieNode(boolean)}.
   * <p>
   * Method under test: {@link Node#dumpTrieNode(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List Node.dumpTrieNode(boolean)"})
  public void testNodeDumpTrieNode() {
    // Arrange, Act and Assert
    assertTrue(
        ((new TrieImpl()).new Node(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17})).dumpTrieNode(true).isEmpty());
  }

  /**
   * Test Node {@link Node#dumpTrieNode(boolean)}.
   * <p>
   * Method under test: {@link Node#dumpTrieNode(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List Node.dumpTrieNode(boolean)"})
  public void testNodeDumpTrieNode2() {
    // Arrange, Act and Assert
    assertTrue(((new TrieImpl()).new Node(new byte[]{Byte.MIN_VALUE, 17, 'A', 17, 'A', 17, 'A', 17})).dumpTrieNode(true)
        .isEmpty());
  }

  /**
   * Test Node {@link Node#dumpTrieNode(boolean)}.
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl, byte[])} with this$0 is {@link TrieImpl#TrieImpl()} and hashOrRlp is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#dumpTrieNode(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List Node.dumpTrieNode(boolean)"})
  public void testNodeDumpTrieNode_givenNodeWithThis$0IsTrieImplAndHashOrRlpIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertTrue(((new TrieImpl()).new Node(new byte[]{})).dumpTrieNode(true).isEmpty());
  }

  /**
   * Test Node {@link Node#dumpTrieNode(boolean)}.
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl, int)} with this$0 is {@link TrieImpl#TrieImpl()} and length is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#dumpTrieNode(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List Node.dumpTrieNode(boolean)"})
  public void testNodeDumpTrieNode_givenNodeWithThis$0IsTrieImplAndLengthIsThree() {
    // Arrange, Act and Assert
    assertTrue(((new TrieImpl()).new Node(3)).dumpTrieNode(true).isEmpty());
  }

  /**
   * Test Node {@link Node#dumpTrieNode(boolean)}.
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#dumpTrieNode(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List Node.dumpTrieNode(boolean)"})
  public void testNodeDumpTrieNode_givenNodeWithThis$0IsTrieImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(((new TrieImpl()).new Node()).dumpTrieNode(true).isEmpty());
  }

  /**
   * Test Node {@link Node#encode()}.
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl, int)} with this$0 is {@link TrieImpl#TrieImpl()} and length is three.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#encode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Node.encode()"})
  public void testNodeEncode_givenNodeWithThis$0IsTrieImplAndLengthIsThree_thenReturnNull() {
    // Arrange
    Node node = (new TrieImpl()).new Node(3);

    // Act and Assert
    assertNull(node.encode());
    assertNull(node.hash);
  }

  /**
   * Test Node {@link Node#getType()}.
   * <p>
   * Method under test: {@link Node#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NodeType Node.getType()"})
  public void testNodeGetType() {
    // Arrange, Act and Assert
    assertEquals(NodeType.BranchNode,
        ((new TrieImpl()).new Node(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17})).getType());
  }

  /**
   * Test Node {@link Node#getType()}.
   * <p>
   * Method under test: {@link Node#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NodeType Node.getType()"})
  public void testNodeGetType2() {
    // Arrange, Act and Assert
    assertEquals(NodeType.BranchNode,
        ((new TrieImpl()).new Node(new byte[]{Byte.MIN_VALUE, 17, 'A', 17, 'A', 17, 'A', 17})).getType());
  }

  /**
   * Test Node {@link Node#getType()}.
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl, byte[])} with this$0 is {@link TrieImpl#TrieImpl()} and hashOrRlp is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NodeType Node.getType()"})
  public void testNodeGetType_givenNodeWithThis$0IsTrieImplAndHashOrRlpIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertEquals(NodeType.BranchNode, ((new TrieImpl()).new Node(new byte[]{})).getType());
  }

  /**
   * Test Node {@link Node#getType()}.
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then return {@code BranchNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NodeType Node.getType()"})
  public void testNodeGetType_givenNodeWithThis$0IsTrieImpl_thenReturnBranchNode() {
    // Arrange, Act and Assert
    assertEquals(NodeType.BranchNode, ((new TrieImpl()).new Node()).getType());
  }

  /**
   * Test Node {@link Node#getType()}.
   * <ul>
   *   <li>Then return {@code KVNodeValue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NodeType Node.getType()"})
  public void testNodeGetType_thenReturnKVNodeValue() {
    // Arrange, Act and Assert
    assertEquals(NodeType.KVNodeValue, ((new TrieImpl()).new Node(3)).getType());
  }

  /**
   * Test Node getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Node#setNodeType(NodeType)}
   *   <li>{@link Node#invalidate()}
   *   <li>{@link Node#getNodeType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NodeType Node.getNodeType()", "Node Node.invalidate()", "Node Node.setNodeType(NodeType)"})
  public void testNodeGettersAndSetters() {
    // Arrange
    Node node = (new TrieImpl()).new Node();

    // Act
    Node actualSetNodeTypeResult = node.setNodeType(NodeType.BranchNode);
    Node actualInvalidateResult = node.invalidate();

    // Assert
    assertEquals(NodeType.BranchNode, node.getNodeType());
    assertSame(node, actualInvalidateResult);
    assertSame(node, actualSetNodeTypeResult);
  }

  /**
   * Test Node {@link Node#kvNodeGetKey()}.
   * <p>
   * Method under test: {@link Node#kvNodeGetKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TrieKey Node.kvNodeGetKey()"})
  public void testNodeKvNodeGetKey() {
    // Arrange, Act and Assert
    assertNull(((new TrieImpl()).new Node(3)).kvNodeGetKey());
  }

  /**
   * Test Node {@link Node#kvNodeGetValue()}.
   * <p>
   * Method under test: {@link Node#kvNodeGetValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Node.kvNodeGetValue()"})
  public void testNodeKvNodeGetValue() {
    // Arrange, Act and Assert
    assertNull(((new TrieImpl()).new Node(3)).kvNodeGetValue());
  }

  /**
   * Test Node {@link Node#kvNodeGetValueOrNode()}.
   * <p>
   * Method under test: {@link Node#kvNodeGetValueOrNode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object Node.kvNodeGetValueOrNode()"})
  public void testNodeKvNodeGetValueOrNode() {
    // Arrange, Act and Assert
    assertNull(((new TrieImpl()).new Node(3)).kvNodeGetValueOrNode());
  }

  /**
   * Test Node {@link Node#kvNodeSetValue(byte[])}.
   * <p>
   * Method under test: {@link Node#kvNodeSetValue(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Node.kvNodeSetValue(byte[])"})
  public void testNodeKvNodeSetValue() throws UnsupportedEncodingException {
    // Arrange
    Node node = (new TrieImpl()).new Node(3);

    // Act and Assert
    assertSame(node, node.kvNodeSetValue("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Node {@link Node#kvNodeSetValueOrNode(Object)}.
   * <p>
   * Method under test: {@link Node#kvNodeSetValueOrNode(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Node Node.kvNodeSetValueOrNode(Object)"})
  public void testNodeKvNodeSetValueOrNode() {
    // Arrange
    Node node = (new TrieImpl()).new Node(3);

    // Act and Assert
    assertSame(node, node.kvNodeSetValueOrNode("Value Or Node"));
  }

  /**
   * Test Node {@link Node#Node(TrieImpl)}.
   * <p>
   * Method under test: {@link Node#Node(TrieImpl)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Node.<init>(TrieImpl)"})
  public void testNodeNewNode() {
    // Arrange and Act
    Node actualNode = (new TrieImpl()).new Node();

    // Assert
    assertNull(actualNode.hash);
    assertNull(actualNode.getNodeType());
    assertEquals(NodeType.BranchNode, actualNode.getType());
  }

  /**
   * Test Node {@link Node#Node(TrieImpl, TrieKey, Object)}.
   * <p>
   * Method under test: {@link Node#Node(TrieImpl, TrieKey, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Node.<init>(TrieImpl, TrieKey, Object)"})
  public void testNodeNewNode2() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act
    Node actualNode = trieImpl.new Node(TrieKey.empty(true), "Value Or Node");

    // Assert
    assertNull(actualNode.hash);
    assertNull(actualNode.getNodeType());
    assertEquals(NodeType.KVNodeValue, actualNode.getType());
  }

  /**
   * Test Node {@link Node#Node(TrieImpl, byte[])}.
   * <p>
   * Method under test: {@link Node#Node(TrieImpl, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Node.<init>(TrieImpl, byte[])"})
  public void testNodeNewNode3() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act
    Node actualNode = trieImpl.new Node("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualNode.hash);
    assertNull(actualNode.getNodeType());
    assertEquals(NodeType.BranchNode, actualNode.getType());
  }

  /**
   * Test Node {@link Node#Node(TrieImpl, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@link Node#hash} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#Node(TrieImpl, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Node.<init>(TrieImpl, int)"})
  public void testNodeNewNode_whenThree_thenReturnHashIsNull() {
    // Arrange and Act
    Node actualNode = (new TrieImpl()).new Node(3);

    // Assert
    assertNull(actualNode.hash);
    assertNull(actualNode.getNodeType());
    assertEquals(NodeType.KVNodeValue, actualNode.getType());
  }

  /**
   * Test Node {@link Node#resolveCheck()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#resolveCheck()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Node.resolveCheck()"})
  public void testNodeResolveCheck_givenA() {
    // Arrange, Act and Assert
    assertTrue(((new TrieImpl()).new Node(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1})).resolveCheck());
  }

  /**
   * Test Node {@link Node#resolveCheck()}.
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#resolveCheck()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Node.resolveCheck()"})
  public void testNodeResolveCheck_givenNodeWithThis$0IsTrieImpl() {
    // Arrange, Act and Assert
    assertTrue(((new TrieImpl()).new Node()).resolveCheck());
  }

  /**
   * Test Node {@link Node#toString()}.
   * <p>
   * Method under test: {@link Node#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Node.toString()"})
  public void testNodeToString() {
    // Arrange, Act and Assert
    assertEquals("BranchNode", ((new TrieImpl()).new Node(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17})).toString());
  }

  /**
   * Test Node {@link Node#toString()}.
   * <p>
   * Method under test: {@link Node#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Node.toString()"})
  public void testNodeToString2() {
    // Arrange, Act and Assert
    assertEquals("BranchNode",
        ((new TrieImpl()).new Node(new byte[]{Byte.MIN_VALUE, 17, 'A', 17, 'A', 17, 'A', 17})).toString());
  }

  /**
   * Test Node {@link Node#toString()}.
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl, byte[])} with this$0 is {@link TrieImpl#TrieImpl()} and hashOrRlp is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Node.toString()"})
  public void testNodeToString_givenNodeWithThis$0IsTrieImplAndHashOrRlpIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertEquals("BranchNode", ((new TrieImpl()).new Node(new byte[]{})).toString());
  }

  /**
   * Test Node {@link Node#toString()}.
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then return {@code BranchNode *}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Node.toString()"})
  public void testNodeToString_givenNodeWithThis$0IsTrieImpl_thenReturnBranchNode() {
    // Arrange, Act and Assert
    assertEquals("BranchNode *", ((new TrieImpl()).new Node()).toString());
  }

  /**
   * Test Node {@link Node#toString()}.
   * <ul>
   *   <li>Then return {@code KVNodeValue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Node.toString()"})
  public void testNodeToString_thenReturnKVNodeValue() {
    // Arrange, Act and Assert
    assertEquals("KVNodeValue", ((new TrieImpl()).new Node(3)).toString());
  }

  /**
   * Test {@link TrieImpl#put(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then {@link TrieImpl#TrieImpl()} Cache size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#put(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.put(byte[], byte[])"})
  public void testPutWithByteByte_givenTrieImpl_thenTrieImplCacheSizeIsZero() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), new byte[]{});

    // Assert that nothing has changed
    DB<byte[], BytesCapsule> cache = trieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertEquals(0L, cache.size());
    assertTrue(cache.isEmpty());
    assertArrayEquals(new byte[]{'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
        -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'}, trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#put(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then {@link TrieImpl#TrieImpl()} Root NodeType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#put(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.put(byte[], byte[])"})
  public void testPutWithByteByte_givenTrieImpl_thenTrieImplRootNodeTypeIsNull() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");

    // Act
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Node root = trieImpl.getRoot();
    assertNull(root.getNodeType());
    assertEquals(NodeType.KVNodeValue, root.getType());
    byte[] rootHash = trieImpl.getRootHash();
    assertSame(rootHash, root.hash);
    assertArrayEquals(new byte[]{-52, -74, '\n', ';', '5', '\b', -16, 18, '}', -24, '/', -122, -41, -5, 'x', 'x', -67,
        'y', 4, 'm', -85, 'x', '[', -58, '"', 'm', 21, -119, 'h', -91, -39, '2'}, rootHash);
  }

  /**
   * Test {@link TrieImpl#put(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link TrieImpl#TrieImpl()} Cache size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#put(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.put(byte[], byte[])"})
  public void testPutWithByteByte_givenTrieImpl_whenNull_thenTrieImplCacheSizeIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), null);

    // Assert that nothing has changed
    DB<byte[], BytesCapsule> cache = trieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertEquals(0L, cache.size());
    assertTrue(cache.isEmpty());
    assertArrayEquals(new byte[]{'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
        -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'}, trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#put(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   * <ul>
   *   <li>Then {@link TrieImpl#TrieImpl(byte[])} with root is array of {@code byte} with {@code A} and one Cache size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#put(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.put(byte[], byte[])"})
  public void testPutWithByteByte_thenTrieImplWithRootIsArrayOfByteWithAAndOneCacheSizeIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), null);

    // Assert that nothing has changed
    DB<byte[], BytesCapsule> cache = trieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertEquals(0L, cache.size());
    assertTrue(cache.isEmpty());
  }

  /**
   * Test {@link TrieImpl#put(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   * <ul>
   *   <li>Then {@link TrieImpl#TrieImpl(byte[])} with root is array of {@code byte} with {@code A} and one Cache size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#put(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.put(byte[], byte[])"})
  public void testPutWithByteByte_thenTrieImplWithRootIsArrayOfByteWithAAndOneCacheSizeIsZero2()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), new byte[]{});

    // Assert that nothing has changed
    DB<byte[], BytesCapsule> cache = trieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertEquals(0L, cache.size());
    assertTrue(cache.isEmpty());
  }

  /**
   * Test {@link TrieImpl#delete(byte[])} with {@code key}.
   * <p>
   * Method under test: {@link TrieImpl#delete(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.delete(byte[])"})
  public void testDeleteWithKey() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[]{Byte.MIN_VALUE, 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    trieImpl.delete("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    DB<byte[], BytesCapsule> cache = trieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertEquals(0L, cache.size());
    assertTrue(cache.isEmpty());
  }

  /**
   * Test {@link TrieImpl#delete(byte[])} with {@code key}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then {@link TrieImpl#TrieImpl()} Cache size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#delete(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.delete(byte[])"})
  public void testDeleteWithKey_givenTrieImpl_thenTrieImplCacheSizeIsZero() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act
    trieImpl.delete("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    DB<byte[], BytesCapsule> cache = trieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertEquals(0L, cache.size());
    assertTrue(cache.isEmpty());
    assertArrayEquals(new byte[]{'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
        -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'}, trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#delete(byte[])} with {@code key}.
   * <ul>
   *   <li>Then {@link TrieImpl#TrieImpl(byte[])} with root is array of {@code byte} with {@code A} and one Cache size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#delete(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.delete(byte[])"})
  public void testDeleteWithKey_thenTrieImplWithRootIsArrayOfByteWithAAndOneCacheSizeIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    trieImpl.delete("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    DB<byte[], BytesCapsule> cache = trieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertEquals(0L, cache.size());
    assertTrue(cache.isEmpty());
  }

  /**
   * Test {@link TrieImpl#delete(byte[])} with {@code key}.
   * <ul>
   *   <li>Then {@link TrieImpl#TrieImpl(byte[])} with root is empty array of {@code byte} Cache {@link ConcurrentHashDB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#delete(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.delete(byte[])"})
  public void testDeleteWithKey_thenTrieImplWithRootIsEmptyArrayOfByteCacheConcurrentHashDB()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[]{});

    // Act
    trieImpl.delete("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    DB<byte[], BytesCapsule> cache = trieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertEquals(0L, cache.size());
    assertTrue(cache.isEmpty());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_givenTrieImplWithRootIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new TrieImpl("AXAXAXAX".getBytes("UTF-8"))).getRootHash());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then return array of {@code byte} with {@code V} and minus twenty-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_givenTrieImpl_thenReturnArrayOfByteWithVAndMinusTwentyFour() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
        -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'}, (new TrieImpl()).getRootHash());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code C} and minus thirty-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_thenReturnArrayOfByteWithCAndMinusThirtyFour() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'X', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{'C', -34, -68, 'Q', -107, -12, ',', 'D', '{', -76, '0', -119, -3, 'C', -6, -111, 'J',
        28, 'g', -1, '@', -59, 'J', -124, '`', 'b', -41, -100, -85, 'B', '~', 'T'}, trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus fifty and {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_thenReturnArrayOfByteWithMinusFiftyAndSlash() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{-50, '/', -52, 22, -120, -69, '?', 'I', 'R', 'a', 'x', '$', 2, -99, 'f', -123, -124,
        -23, '1', -2, 'h', '4', 11, 7, '"', -94, -33, '+', -95, '~', 'y', '|'}, trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus fifty-two and minus seventy-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_thenReturnArrayOfByteWithMinusFiftyTwoAndMinusSeventyFour()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{-52, -74, '\n', ';', '5', '\b', -16, 18, '}', -24, '/', -122, -41, -5, 'x', 'x', -67,
        'y', 4, 'm', -85, 'x', '[', -58, '"', 'm', 21, -119, 'h', -91, -39, '2'}, trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus sixty and form feed (ff).</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_thenReturnArrayOfByteWithMinusSixtyAndFormFeed() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{-60, '\f', '4', 28, -74, -2, -117, -83, -88, 'J', 15, 17, -60, 'k', -39, 17, 24, -56,
        -49, '2', -82, -22, -9, -126, -88, 31, -99, -123, 17, -31, -65, -99}, trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus sixty and minus thirty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_thenReturnArrayOfByteWithMinusSixtyAndMinusThirtySix()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(new byte[]{-60, -36, -82, -122, -53, 'm', -50, '&', -102, -27, 'k', 'H', -55, -61, -57, '1', 'Q',
        -82, -104, 'b', -75, '8', -51, 'y', '?', -76, -91, 't', -16, -98, -88, -15}, trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#clear()}.
   * <p>
   * Method under test: {@link TrieImpl#clear()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.clear()"})
  public void testClear() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new TrieImpl()).clear());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   * <p>
   * Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(trieImpl.flush());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   * <p>
   * Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush2() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(trieImpl.flush());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} array of {@code byte} with {@code A} and three is array of {@code byte} with {@code A} and three.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush_givenTrieImplArrayOfByteWithAAndThreeIsArrayOfByteWithAAndThree()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(trieImpl.flush());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} array of {@code byte} with {@code X} and three is array of {@code byte} with {@code A} and three.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush_givenTrieImplArrayOfByteWithXAndThreeIsArrayOfByteWithAAndThree()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'X', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});
    trieImpl.put(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(trieImpl.flush());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} {@code AXAXAXAX} Bytes is {@code UTF-8} is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush_givenTrieImplAxaxaxaxBytesIsUtf8IsAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(trieImpl.flush());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush_givenTrieImplWithRootIsAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse((new TrieImpl("AXAXAXAX".getBytes("UTF-8"))).flush());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush_givenTrieImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TrieImpl()).flush());
  }

  /**
   * Test {@link TrieImpl#equals(Object)}, and {@link TrieImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TrieImpl#equals(Object)}
   *   <li>{@link TrieImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.equals(Object)", "int TrieImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    TrieImpl trieImpl2 = new TrieImpl();

    // Act and Assert
    assertEquals(trieImpl, trieImpl2);
    int notExpectedHashCodeResult = trieImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, trieImpl2.hashCode());
  }

  /**
   * Test {@link TrieImpl#equals(Object)}, and {@link TrieImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TrieImpl#equals(Object)}
   *   <li>{@link TrieImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.equals(Object)", "int TrieImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act and Assert
    assertEquals(trieImpl, trieImpl);
    int expectedHashCodeResult = trieImpl.hashCode();
    assertEquals(expectedHashCodeResult, trieImpl.hashCode());
  }

  /**
   * Test {@link TrieImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.equals(Object)", "int TrieImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] key = "A A A A ".getBytes("UTF-8");
    trieImpl.put(key, "A A A A ".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(trieImpl, new TrieImpl());
  }

  /**
   * Test {@link TrieImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.equals(Object)", "int TrieImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("A A A A ".getBytes("UTF-8"));
    byte[] key = "A A A A ".getBytes("UTF-8");
    trieImpl.put(key, "A A A A ".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(trieImpl, new TrieImpl());
  }

  /**
   * Test {@link TrieImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.equals(Object)", "int TrieImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    byte[] key = "A A A A ".getBytes("UTF-8");
    trieImpl.put(key, "A A A A ".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(trieImpl, new TrieImpl());
  }

  /**
   * Test {@link TrieImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.equals(Object)", "int TrieImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TrieImpl(), null);
  }

  /**
   * Test {@link TrieImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.equals(Object)", "int TrieImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TrieImpl(), "Different type to TrieImpl");
  }

  /**
   * Test {@link TrieImpl#dumpStructure()}.
   * <p>
   * Method under test: {@link TrieImpl#dumpStructure()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpStructure()"})
  public void testDumpStructure() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new ConcurrentHashDB());
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("KVNodeValue * [4158415841584158T] = 4158415841584158\n", trieImpl.dumpStructure());
  }

  /**
   * Test {@link TrieImpl#dumpStructure()}.
   * <p>
   * Method under test: {@link TrieImpl#dumpStructure()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpStructure()"})
  public void testDumpStructure2() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("BranchNode *\n  [4] KVNodeValue * [158415841584158T] = 4158415841584158\n", trieImpl.dumpStructure());
  }

  /**
   * Test {@link TrieImpl#dumpStructure()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#dumpStructure()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpStructure()"})
  public void testDumpStructure_givenA_thenReturnAString() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17}, new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "KVNodeNode * [41]\n" + "  BranchNode *\n" + "    [1] KVNodeValue * [1411141114111T] = 4111411141114111\n"
            + "    [5] KVNodeValue * [8415841584158T] = 4158415841584158\n",
        trieImpl.dumpStructure());
  }

  /**
   * Test {@link TrieImpl#dumpStructure()}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then return {@code <empty>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#dumpStructure()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpStructure()"})
  public void testDumpStructure_givenTrieImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals("<empty>", (new TrieImpl()).dumpStructure());
  }

  /**
   * Test {@link TrieImpl#dumpStructure()}.
   * <ul>
   *   <li>Then return {@code BranchNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#dumpStructure()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpStructure()"})
  public void testDumpStructure_thenReturnBranchNode() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("BranchNode\n", (new TrieImpl("AXAXAXAX".getBytes("UTF-8"))).dumpStructure());
  }

  /**
   * Test {@link TrieImpl#dumpStructure()}.
   * <ul>
   *   <li>Then return {@code KVNodeValue * [4158415841584158T] = 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#dumpStructure()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpStructure()"})
  public void testDumpStructure_thenReturnKVNodeValue4158415841584158t4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("KVNodeValue * [4158415841584158T] = 4158415841584158\n", trieImpl.dumpStructure());
  }

  /**
   * Test {@link TrieImpl#dumpTrie(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TrieImpl#dumpTrie(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpTrie(boolean)"})
  public void testDumpTrieWithBoolean() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("Root: 0xccb60a3b\n0xccb60a3b ==> [<4158415841584158T>, \"4158415841584158\"]\n",
        trieImpl.dumpTrie(true));
  }

  /**
   * Test {@link TrieImpl#dumpTrie(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TrieImpl#dumpTrie(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpTrie(boolean)"})
  public void testDumpTrieWithBoolean2() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("Root: 0xc4dcae86\n0xc4dcae86 ==> [,,,,[<158415841584158T>, \"4158415841584158\"],,,,,,,,,,,]\n",
        trieImpl.dumpTrie(true));
  }

  /**
   * Test {@link TrieImpl#dumpTrie(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TrieImpl#dumpTrie(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpTrie(boolean)"})
  public void testDumpTrieWithBoolean3() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("Root: 0xce2fcc16\n" + "0xce2fcc16 ==> [<41>, 0xc0613c23]\n"
        + "0xc0613c23 ==> [[<1410141014101T>, \"4101410141014101\"],,,,,[<8415841584158T>, \"4158415841584158\"],,,,,,,,,,]"
        + "\n", trieImpl.dumpTrie(true));
  }

  /**
   * Test {@link TrieImpl#dumpTrie(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TrieImpl#dumpTrie(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpTrie(boolean)"})
  public void testDumpTrieWithBoolean4() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("Root: 0xc40c341c\n" + "0xc40c341c ==> [,,,,0x7766d698,,,,,,,,,,,]\n"
        + "0x7766d698 ==> [<1>, 0xc0613c23]\n"
        + "0xc0613c23 ==> [[<1410141014101T>, \"4101410141014101\"],,,,,[<8415841584158T>, \"4158415841584158\"],,,,,,,,,,]"
        + "\n", trieImpl.dumpTrie(true));
  }

  /**
   * Test {@link TrieImpl#dumpTrie(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TrieImpl#dumpTrie(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpTrie(boolean)"})
  public void testDumpTrieWithBoolean5() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'X', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("Root: 0x43debc51\n"
        + "0x43debc51 ==> [,,,,0x7766d698,[<801410141014101T>, \"4101410141014101\"],,,,,,,,,,]\n"
        + "0x7766d698 ==> [<1>, 0xc0613c23]\n"
        + "0xc0613c23 ==> [[<1410141014101T>, \"4101410141014101\"],,,,,[<8415841584158T>, \"4158415841584158\"],,,,,,,,,,]"
        + "\n", trieImpl.dumpTrie(true));
  }

  /**
   * Test {@link TrieImpl#dumpTrie(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then return {@code <empty>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#dumpTrie(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpTrie(boolean)"})
  public void testDumpTrieWithBoolean_givenTrieImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals("<empty>", (new TrieImpl()).dumpTrie(true));
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} array of {@code byte} with {@code A} and {@code A} is array of {@code byte} with {@code A} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_givenTrieImplArrayOfByteWithAAndAIsArrayOfByteWithAAndOne() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'A', 'A', 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals("Root: 0x65075e45\n" + "0x65075e45 ==> [<41>, 0x6cbe9eab]\n"
        + "0x6cbe9eab ==> [[<1410141014101T>, \"4101410141014101\"],,,,[<1410141014101T>, \"4101410141014101\"],,,,,,,,,,,]"
        + "\n", trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then return {@code <empty>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_givenTrieImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals("<empty>", (new TrieImpl()).dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   * <ul>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_thenReturnAString() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'X', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals("Root: 0x3fd00e3c\n"
        + "0x3fd00e3c ==> [,,,,[<101410141014101T>, \"4101410141014101\"],[<801410141014101T>, \"4101410141014101\""
        + "],,,,,,,,,,]\n", trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   * <ul>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_thenReturnAString2() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 'A'}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals(
        "Root: 0x8f85a1f9\n" + "0x8f85a1f9 ==> [<41014101410141>, 0xca1260b7]\n"
            + "0xca1260b7 ==> [[<1T>, \"4101410141014101\"],,,,[<1T>, \"4101410141014101\"],,,,,,,,,,,]\n",
        trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   * <ul>
   *   <li>Then return {@code Root: 0x53b4ddb6 0x53b4ddb6 ==> [,,,,[<101410141014101T>, "4101410141014101"],,,,,,,,,,,]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_thenReturnRoot0x53b4ddb60x53b4ddb6101410141014101t4101410141014101() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals("Root: 0x53b4ddb6\n0x53b4ddb6 ==> [,,,,[<101410141014101T>, \"4101410141014101\"],,,,,,,,,,,]\n",
        trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   * <ul>
   *   <li>Then return {@code Root: 0x6428d458 0x6428d458 ==> [,,,,,,,,,,,,,,,, "4101410141014101"]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_thenReturnRoot0x6428d4580x6428d4584101410141014101() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(new byte[]{}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals("Root: 0x6428d458\n0x6428d458 ==> [,,,,,,,,,,,,,,,, \"4101410141014101\"]\n", trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   * <ul>
   *   <li>Then return {@code Root: 0x8658671d 0x8658671d ==> [<4101410141014101T>, "4101410141014101"]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_thenReturnRoot0x8658671d0x8658671d4101410141014101t4101410141014101() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals("Root: 0x8658671d\n0x8658671d ==> [<4101410141014101T>, \"4101410141014101\"]\n", trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   * <ul>
   *   <li>Then return {@code Root: 0xb105f65e 0xb105f65e ==> [<4101410141014101T>, "4101410141... len 24"]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_thenReturnRoot0xb105f65e0xb105f65e4101410141014101t4101410141Len24() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals("Root: 0xb105f65e\n0xb105f65e ==> [<4101410141014101T>, \"4101410141... len 24\"]\n",
        trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#scanTree(Node, TrieKey, ScanAction)} with {@code node}, {@code k}, {@code scanAction}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#scanTree(Node, TrieKey, ScanAction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.scanTree(Node, TrieKey, ScanAction)"})
  public void testScanTreeWithNodeKScanAction_thenThrowRuntimeException() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    Node node = (new TrieImpl()).new Node();
    node.branchNodeSetValue(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17});
    TrieKey k = TrieKey.empty(true);
    ScanAction scanAction = mock(ScanAction.class);
    doThrow(new RuntimeException("Can' append to terminal key: ")).when(scanAction)
        .doOnValue(Mockito.<byte[]>any(), Mockito.<Node>any(), Mockito.<byte[]>any(), Mockito.<byte[]>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> trieImpl.scanTree(node, k, scanAction));
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   * <p>
   * Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));
    ScanAction scanAction = mock(ScanAction.class);
    doNothing().when(scanAction)
        .doOnValue(Mockito.<byte[]>any(), Mockito.<Node>any(), Mockito.<byte[]>any(), Mockito.<byte[]>any());

    // Act
    trieImpl.scanTree(scanAction);

    // Assert
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   * <p>
   * Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction2() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));
    ScanAction scanAction = mock(ScanAction.class);
    doThrow(new RuntimeException("foo")).when(scanAction)
        .doOnValue(Mockito.<byte[]>any(), Mockito.<Node>any(), Mockito.<byte[]>any(), Mockito.<byte[]>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> trieImpl.scanTree(scanAction));
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   * <p>
   * Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction3() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(new byte[]{}, "AXAXAXAX".getBytes("UTF-8"));
    ScanAction scanAction = mock(ScanAction.class);
    doNothing().when(scanAction)
        .doOnValue(Mockito.<byte[]>any(), Mockito.<Node>any(), Mockito.<byte[]>any(), Mockito.<byte[]>any());

    // Act
    trieImpl.scanTree(scanAction);

    // Assert
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction_givenA_thenThrowRuntimeException() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17}, new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));
    ScanAction scanAction = mock(ScanAction.class);
    doThrow(new RuntimeException("foo")).when(scanAction)
        .doOnValue(Mockito.<byte[]>any(), Mockito.<Node>any(), Mockito.<byte[]>any(), Mockito.<byte[]>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> trieImpl.scanTree(scanAction));
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link ScanAction} {@link ScanAction#doOnValue(byte[], Node, byte[], byte[])} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction_givenA_whenScanActionDoOnValueDoesNothing()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17}, new byte[]{'A', 17, 'A', 17, 'A', 17, 'A', 17});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));
    ScanAction scanAction = mock(ScanAction.class);
    doNothing().when(scanAction)
        .doOnValue(Mockito.<byte[]>any(), Mockito.<Node>any(), Mockito.<byte[]>any(), Mockito.<byte[]>any());

    // Act
    trieImpl.scanTree(scanAction);

    // Assert
    verify(scanAction, atLeast(1)).doOnValue(isNull(), Mockito.<Node>any(), Mockito.<byte[]>any(),
        Mockito.<byte[]>any());
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} {@code AXAXAXAX} Bytes is {@code UTF-8} is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction_givenTrieImplAxaxaxaxBytesIsUtf8IsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));
    ScanAction scanAction = mock(ScanAction.class);
    doNothing().when(scanAction)
        .doOnValue(Mockito.<byte[]>any(), Mockito.<Node>any(), Mockito.<byte[]>any(), Mockito.<byte[]>any());

    // Act
    trieImpl.scanTree(scanAction);

    // Assert
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction_thenThrowRuntimeException() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));
    ScanAction scanAction = mock(ScanAction.class);
    doThrow(new RuntimeException("foo")).when(scanAction)
        .doOnValue(Mockito.<byte[]>any(), Mockito.<Node>any(), Mockito.<byte[]>any(), Mockito.<byte[]>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> trieImpl.scanTree(scanAction));
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   * <p>
   * Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(4, trieImpl.prove("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} array of {@code byte} with one and {@code X} is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_givenTrieImplArrayOfByteWithOneAndXIsAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(trieImpl.prove("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} array of {@code byte} with {@code X} and one is array of {@code byte} with {@code A} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_givenTrieImplArrayOfByteWithXAndOneIsArrayOfByteWithAAndOne()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'X', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(4, trieImpl.prove("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_givenTrieImplWithRootIsArrayOfByteWithMin_valueAndX_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertNull(trieImpl.prove("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_givenTrieImplWithRootIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNull(trieImpl.prove("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is empty array of {@code byte}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_givenTrieImplWithRootIsEmptyArrayOfByte_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[]{});

    // Act and Assert
    assertNull(trieImpl.prove("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_givenTrieImpl_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act and Assert
    assertNull(trieImpl.prove("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_thenReturnSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(1, trieImpl.prove("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   * <ul>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_thenReturnSizeIsThree() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(3, trieImpl.prove("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_thenReturnSizeIsTwo() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    trieImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(2, trieImpl.prove("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Test {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.verifyProof(byte[], byte[], LinkedHashMap)"})
  public void testVerifyProof_whenEmptyArrayOfByte_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(trieImpl.verifyProof(new byte[]{}, key, new LinkedHashMap<>()));
  }

  /**
   * Test {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.verifyProof(byte[], byte[], LinkedHashMap)"})
  public void testVerifyProof_whenEmptyArrayOfByte_thenReturnFalse2() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] rootHash = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(trieImpl.verifyProof(rootHash, new byte[]{}, new LinkedHashMap<>()));
  }

  /**
   * Test {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}.
   * <ul>
   *   <li>When {@link LinkedHashMap#LinkedHashMap()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.verifyProof(byte[], byte[], LinkedHashMap)"})
  public void testVerifyProof_whenLinkedHashMap_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] rootHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] key = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(trieImpl.verifyProof(rootHash, key, new LinkedHashMap<>()));
  }

  /**
   * Test {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.verifyProof(byte[], byte[], LinkedHashMap)"})
  public void testVerifyProof_whenNull_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(trieImpl.verifyProof(null, key, new LinkedHashMap<>()));
  }

  /**
   * Test {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TrieImpl.verifyProof(byte[], byte[], LinkedHashMap)"})
  public void testVerifyProof_whenNull_thenReturnFalse2() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] rootHash = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(trieImpl.verifyProof(rootHash, null, new LinkedHashMap<>()));
  }

  /**
   * Test {@link TrieImpl#setRoot(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then {@link TrieImpl#TrieImpl()} RootHash is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#setRoot(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.setRoot(byte[])"})
  public void testSetRoot_whenAxaxaxaxBytesIsUtf8_thenTrieImplRootHashIsNull() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act
    trieImpl.setRoot("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(trieImpl.getRootHash());
    Node root = trieImpl.getRoot();
    assertNull(root.hash);
    assertNull(root.getNodeType());
    assertEquals(NodeType.BranchNode, root.getType());
  }

  /**
   * Test {@link TrieImpl#setRoot(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link TrieImpl#TrieImpl()} RootHash is array of {@code byte} with {@code V} and minus twenty-four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TrieImpl#setRoot(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TrieImpl.setRoot(byte[])"})
  public void testSetRoot_whenNull_thenTrieImplRootHashIsArrayOfByteWithVAndMinusTwentyFour() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act
    trieImpl.setRoot(null);

    // Assert that nothing has changed
    assertArrayEquals(new byte[]{'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
        -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'}, trieImpl.getRootHash());
  }
}
