/* Address Book Service Layer */
package com.bridgelabz.addressbookservice.service;

import com.bridgelabz.addressbookservice.dto.AddressBookDTO;
import com.bridgelabz.addressbookservice.exception.AddressBookException;
import com.bridgelabz.addressbookservice.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    private List<AddressBookData> contactList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookData() {
        return contactList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return contactList.stream()
                .filter(contact -> contact.getPersonId() == personId)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Person Not Found"));
    }

    @Override
    public AddressBookData addNewContact(AddressBookDTO addressBookDTO) {
        AddressBookData contact = null;
        contact = new AddressBookData(contactList.size()+1, addressBookDTO);
        contactList.add(contact);
        return contact;
    }

    @Override
    public AddressBookData updateContact(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData contact = this.getAddressBookDataById(personId);
        contact.setFirstName(addressBookDTO.firstName);
        contact.setLastName(addressBookDTO.lastName);
        contact.setAddress(addressBookDTO.address);
        contact.setAddress(addressBookDTO.mobileNo);
        contactList.set(personId-1, contact);
        return contact;
    }

    @Override
    public void deleteContact(int personId) {
        contactList.remove(personId-1);
    }
}
