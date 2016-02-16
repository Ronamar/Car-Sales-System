package main;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import main.Admin;
import main.Repository;

@XmlRootElement
@XmlSeeAlso(Admin.class)
public class AdminRepository extends Repository<Admin>{

}
