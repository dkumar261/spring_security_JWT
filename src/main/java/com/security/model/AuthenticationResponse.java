/**
 * 
 */
package com.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Dinesh Kumar.
 *
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

	private  String bearer_token;

}
