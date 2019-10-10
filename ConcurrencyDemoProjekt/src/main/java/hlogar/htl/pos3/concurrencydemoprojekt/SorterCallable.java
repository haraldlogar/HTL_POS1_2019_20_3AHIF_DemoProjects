/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.concurrencydemoprojekt;

import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 *
 * @author hlogar
 */
class SorterCallable implements Callable<byte[]>{
	private final byte[] b;
		
	SorterCallable( byte[] b ){
		this.b = b;
	}
	
	public byte[] call(){
		Arrays.sort( b );
		return b;
	}
}
