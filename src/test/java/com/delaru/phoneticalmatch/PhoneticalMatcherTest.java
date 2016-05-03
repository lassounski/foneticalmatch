package com.delaru.phoneticalmatch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.delaru.phoneticalmatch.PhoneticalMatcher;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author delaru
 */
public class PhoneticalMatcherTest {
    
    private PhoneticalMatcher phoneticalMatcher;
    private Set<String> words;
    private File dictionary;
    
    @Before
    public void setUp() {
        words = new HashSet<>();
        words.add("1ton#");
        words.add("brief");
        words.add("soon");
        
        ClassLoader classLoader = getClass().getClassLoader();
        dictionary = new File(classLoader.getResource("word_dict.txt").getFile());
    }
    
    @Test
    public void shouldLoadWordsFromTextFile() {
        phoneticalMatcher = new PhoneticalMatcher(words, dictionary);
        Set<String> dictionary = phoneticalMatcher.getDictionary();
        
        assertThat(dictionary, hasItems("son","angel","Engel"));        
    }

//    @Test
//    public void shouldIgnoreNonAlphabeticalCharacters() {
//        
//    }
}
