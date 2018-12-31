package com.abhishek.classes;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionsList {
	List<String> addressList;
	Set<String>  addressSet;
	Map<Integer, String>  addressMap;
	
	Properties addressProp;
	
	public Properties getAddressProp() {
		return addressProp;
	}
	public void setAddressProp(Properties addressProp) {
		this.addressProp = addressProp;
	}
	public List<String> getAddressList() {
		System.out.println("Address List: " + this.addressList);
		return addressList;
	}
	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}
	public Set<String> getAddressSet() {
		System.out.println("Address Set: " + this.addressSet);
		return addressSet;
	}
	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}
	public Map<Integer, String> getAddressMap() {
		System.out.println("Address Map: " + this.addressMap);
		return addressMap;
	}
	public void setAddressMap(Map<Integer, String> addressMap) {
		this.addressMap = addressMap;
	}
	
	
}
