package com.example.memorycard.models;

import android.support.v7.app.AlertDialog;
import android.widget.Chronometer;
import android.widget.Toast;

import com.example.memorycard.MainActivity;
import com.example.memorycard.views.CardView;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;

public class Memory
{
    CardView selectCard;

    public Memory()
    {
        selectCard=null;
    }

    public void setSelectCard(int nbCartes, int nbCardVisible, ArrayList<CardView> CardVisible, FlexboxLayout flexboxlayout,
                              CardView v, Chronometer timer)
    {
        for (int i=0;i<flexboxlayout.getFlexItemCount();i++)
        {
            CardView card = (CardView) flexboxlayout.getFlexItemAt(i);
            if (card.isTurn()==false&& card.isFind()==false)
            {
                nbCardVisible++;
                CardVisible.add(card);
            }
        }
        if (nbCardVisible ==2)
        {
            CardVisible.get(0).setTurn(true);
            CardVisible.get(1).setTurn(true);
        }
        CardView cardView = (CardView) v;
        cardView.setTurn(false);

        nbCardVisible=0;
        int nbCardTrouve = 0;
        CardVisible.clear();
        for (int i=0;i<flexboxlayout.getFlexItemCount();i++)
        {
            CardView card = (CardView) flexboxlayout.getFlexItemAt(i);
            if (card.isTurn()==false)
            {
                if (card.isFind()==true)
                {
                    nbCardTrouve++;
                }
                else
                {
                    nbCardVisible++;
                    CardVisible.add(card);
                }
            }
        }

        if (nbCardVisible ==2)
        {
            if (isSame(CardVisible.get(0),CardVisible.get(1))==true)
            {
                CardVisible.get(0).setFind(true);
                CardVisible.get(1).setFind(true);
            }
        }
        else if (nbCardTrouve == nbCartes)
        {
            //timer.stop();
        }
    }

    public boolean isBlack(CardView c)
    {
        return (c.getCardColor().equals("TREFLE") || c.getCardColor().equals("PIQUE"));
    }

    public boolean isSame(CardView c1, CardView c2)
    {
        return (isBlack(c1) && isBlack(c2) && c1.getCardValue().equals(c2.getCardValue())) ||
                (!isBlack(c1) && !isBlack(c2) && c1.getCardValue().equals(c2.getCardValue()));
    }
}
