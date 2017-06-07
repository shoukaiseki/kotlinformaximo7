package com.wmc.app.mobilevers;

import java.rmi.RemoteException;

import psdi.util.MXApplicationYesNoCancelException;
import psdi.util.MXException;
import psdi.webclient.system.beans.AppBean;

public class TestAppBean extends AppBean{
	
	
	
	@Override
	public int SAVE() throws MXException, RemoteException {
		// TODO Auto-generated method stub
		return super.SAVE();
	}
	
	public void TEST(){
		new MXApplicationYesNoCancelException("test","mobileversion", "autoseturl");
		refreshTable();  
		fireStructureChangedEvent();
	}

}
