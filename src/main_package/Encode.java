package main_package;

import java.security.*;
import java.io.*;

class Encode {

    MessageDigest message_digest;
    byte[] hash;
    String input;

    public Encode(String input)throws NoSuchAlgorithmException {
        this.input = input;

           message_digest = MessageDigest.getInstance("SHA-256");

    }

   public Encode()throws NoSuchAlgorithmException {

        message_digest = MessageDigest.getInstance("SHA-256");
    }

    public void setInput(String input){
    	this.input = input;
    }

    public byte[] hash() throws UnsupportedEncodingException{
        return message_digest.digest(getInput().getBytes("UTF-8"));
    }

    public String getInput(){
        return this.input;
    }

    public String getHashAsHex() throws UnsupportedEncodingException{
        return bytesToHex(hash());
    }

    public static String bytesToHex(byte[] bytes) {
	 char[] hexArray = "0123456789ABCDEF".toCharArray();

	char[] hexChars = new char[bytes.length * 2];
	for ( int j = 0; j < bytes.length; j++ ) {
	    int v = bytes[j] & 0xFF;
	    hexChars[j * 2] = hexArray[v >>> 4];
	    hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	}
	return new String(hexChars);
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
	System.out.println("hello world");
        Encode encode = new Encode("hello world");
        byte[] arr = encode.hash();
        System.out.println(encode.getHashAsHex());
        //System.out.println(encode.hash().bytesToHex());
	//String s = new String(encode.hash(), "UTF-8");
	//System.out.println(s);
    }
}
