/*
 * Copyright 2015-2025 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package fucksocks.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;

import fucksocks.common.SocksException;
import fucksocks.server.msg.WritableMessage;
import fucksocks.server.msg.ReadableMessage;

/**
 * The class <code>Session</code> represents a session between client with SOCKS server.
 * This class is simple encapsulation of java.net.Socket.
 * 
 * @author Youchao Feng
 * @date Apr 5, 2015 10:21:28 AM
 * @version 1.0
 *
 */
public interface Session {

  /**
   * Gets socket.
   * 
   * @return socket that connected remote host.
   */
  public Socket getSocket();

  /**
   * Writes bytes in output stream.
   * 
   * @param bytes Bytes
   * @throws SocksException If a SOCKS protocol error occurred.
   * @throws IOException If an I/O error occurred.
   */
  public void write(byte[] bytes) throws SocksException, IOException;

  /**
   * Writes bytes in output stream.
   * 
   * @param bytes Bytes
   * @param offset Offset
   * @param length Bytes length.
   * @throws SocksException If a SOCKS protocol error occurred.
   * @throws IOException If an I/O error occurred.
   */
  public void write(byte[] bytes, int offset, int length) throws SocksException, IOException;

  /**
   * Writes <code>Message</code> in output stream.
   * 
   * @param message {@link WritableMessage} instance.
   * @throws SocksException If a SOCKS protocol error occurred.
   * @throws IOException If an I/O error occurred.
   */
  public void write(WritableMessage message) throws SocksException, IOException;

  /**
   * Read a buffer.
   * 
   * @param byetes Buffer which read in.
   * @return Read length
   * @throws SocksException If a SOCKS protocol error occurred.
   * @throws IOException If an I/O error occurred.
   */
  public int read(byte[] byetes) throws SocksException, IOException;

  /**
   * Reads a message.
   * 
   * @param message a readable message.
   * @return Read bytes size.
   * @throws SocksException If a SOCKS protocol error occurred.
   * @throws IOException If an I/O error occurred.
   */
  public int read(ReadableMessage message) throws SocksException, IOException;

  /**
   * Gets session ID.
   * 
   * @return session ID.
   */
  public long getId();


  /**
   * Closes connection.
   */
  public void close();

  /**
   * Gets input stream.
   * 
   * @return Input stream.
   */
  public InputStream getInputStream();

  /**
   * Gets output stream.
   * 
   * @return Output stream.
   */
  public OutputStream getOutputStream();


  /**
   * Gets all sessions that be managed.
   * 
   * @return All sessions.
   */
  public Map<Long, Session> getManagedSessions();

  /**
   * Get remote host's IP address and port.
   * 
   * @return Remote host's IP address and port.
   */
  public SocketAddress getRemoteAddress();

  public void setAttribute(Object key, Object value);

  public Object getAttribute(Object key);

  /**
   * Returns all attributes.
   * 
   * @return All attributes.
   */
  public Map<Object, Object> getAttributes();

  /**
   * Clear all attributes in session.
   */
  public void clearAllAttributes();

  /**
   * Returns <code>true</code> if the session is closed.
   * 
   * @return If the session is closed, it returns <code>true</code>.
   */
  public boolean isClose();

  /**
   * Returns <code>true</code> if the session is connected.
   * 
   * @return If the session is connected returns <code>true</code>.
   */
  public boolean isConnected();

}
