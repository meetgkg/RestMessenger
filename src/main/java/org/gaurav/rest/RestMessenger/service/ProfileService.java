package org.gaurav.rest.RestMessenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.gaurav.rest.RestMessenger.database.DatabaseClass;
import org.gaurav.rest.RestMessenger.model.Profile;

public class ProfileService {
	
	private static Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("Gaurav", new Profile(1L, "Gaurav", "Gaurav", "Gupta"));
		profiles.put("Anamika", new Profile(2L, "Anamika", "Anamika", "Gupta"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getId() <= 0){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public void removeProfile(String profileName){
		profiles.remove(profileName);
	}
}
