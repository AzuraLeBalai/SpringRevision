package fr.but3.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public record Flight (String ig, String pilot, List<String> passagers){
}
