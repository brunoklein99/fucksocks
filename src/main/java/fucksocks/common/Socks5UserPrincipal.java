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

package fucksocks.common;

import java.io.Serializable;
import java.security.Principal;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.hash.Hashing;

/**
 * The class <code>Socks5UserPrincipal</code> represents a SOKCS5 user principal.
 *
 * @author Youchao Feng
 * @date May 14, 2015 2:35:53 PM
 * @version 1.0
 *
 */
public class Socks5UserPrincipal implements Principal, Serializable {

  /**
   * Serial version UID
   */
  private static final long serialVersionUID = 1L;
  private String username;

  public Socks5UserPrincipal(String username) {
    Preconditions.checkArgument(username != null, "User name may not be null");
    this.username = username;
  }

  @Override
  public String getName() {
    return this.username;
  }

  @Override
  public int hashCode() {
    return Hashing.md5().newHasher().putString(username, Charsets.UTF_8).hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof Socks5UserPrincipal) {
      final Socks5UserPrincipal that = (Socks5UserPrincipal) obj;
      if (this.username.equals(that.username)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format("Principal[%s]", this.username);
  }

}
