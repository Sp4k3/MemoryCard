package com.example.memorycard.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> cards;

    public Deck()
    {
        cards = new ArrayList<Card>();
        String[] colors = {"PIQUE", "TREFLE", "COEUR", "CARREAU"};
        for(String c: colors)
        {
            for(int i=13; i>0; i--)
            {
                switch (i)
                {
                    case 1:
                        cards.add(new Card(c, "A"));
                        break;
                    case 11:
                        cards.add(new Card(c, "V"));
                        break;
                    case 12:
                        cards.add(new Card(c, "D"));
                        break;
                    case 13:
                        cards.add(new Card(c, "R"));
                        break;
                    case 2:
                    default:
                        cards.add(new Card(c, i+""));
                        break;
                }
            }
        }
    }

    public Deck(int nbChoisi)
    {
        cards = new ArrayList<Card>();
        String[][] colors;
        switch (nbChoisi)
        {
            case 3:
                colors = new String[][]{{"PIQUE", "2"}, {"TREFLE", "2"}, {"COEUR", "1"}, {"CARREAU", "1"}};
                break;
            case 7:
                colors = new String[][]{{"PIQUE", "3"}, {"TREFLE", "3"}, {"COEUR", "4"}, {"CARREAU", "4"}};
                break;
            case 13:
            default:
                colors = new String[][]{{"PIQUE", "7"}, {"TREFLE", "7"}, {"COEUR", "6"}, {"CARREAU", "6"}};
                break;
        }

        for (int i = 0; i < colors.length; i++)
        {
            for (int j = Integer.parseInt(colors[i][1]); j > 0; j--)
            {
                switch (j)
                {
                    case 1:
                        cards.add(new Card(colors[i][0], "A"));
                        break;
                    case 11:
                        cards.add(new Card(colors[i][0], "V"));
                        break;
                    case 12:
                        cards.add(new Card(colors[i][0], "D"));
                        break;
                    case 13:
                        cards.add(new Card(colors[i][0], "R"));
                        break;
                    case 2:
                    default:
                        cards.add(new Card(colors[i][0], j + ""));
                        break;
                }
            }
        }
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    public Card draw()
    {
        Card c = cards.get(0);
        cards.remove(c);
        return c;
    }

    public int count()
    {
        return cards.size();
    }
}
