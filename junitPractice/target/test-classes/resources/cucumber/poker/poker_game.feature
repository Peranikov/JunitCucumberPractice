# language: en
Feature: PokerGame
  Scenario: NoChange/NoPair(NoPat)
    Given hands,S1,H4,D6,D8,C3dealt
    When NoChange
    Then NoPair

  Scenario: NoChange/OnePair(NoPat)
    Given hands,S1,H1,D6,D8,C3dealt
    When NoChange
    Then OnePairFor1