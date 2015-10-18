package pokerBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pokerEnums.eCardNo;
import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Wild_Joker_Test {
	@Test
	public void FiveOfAKindWilds() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.SIX, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.SIX, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.SIX, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.SIX, 0));

		int NbrOfJokers = 0;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SIX, true));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.FIVE, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.FIVE, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.FIVE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.FIVE, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());

		assertTrue(h.getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.FIVE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void FiveOfAKindJoker() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.QUEEN, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.QUEEN, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.QUEEN, 0));

		int NbrOfJokers = 1;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, true));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, true));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.FIVE, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.FIVE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.FIVE, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());

		assertTrue(h.getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.FIVE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}

	
	@Test
	public void FiveOfAKind() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.FIVE, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.FIVE, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.FIVE, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.FIVE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.FIVE, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.FIVE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void NaturalRoyalFlush() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.THREE, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.THREE, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.THREE, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.THREE, 0));

		int NbrOfJokers = 2;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.THREE, true));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, true));
		h = Hand.EvalHand(h);
		
		System.out.println(h.getHandStrength());
		
		assertTrue(h.getbNatural() == 1);
		assertTrue(h.getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == 0);
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void RoyalFlushWilds() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.THREE, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.THREE, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.THREE, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.THREE, 0));

		int NbrOfJokers = 2;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.THREE, true));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.ACE, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());
		assertTrue(h.getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == 0);
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void RoyalFlushJoker() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.FOUR, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.FOUR, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.FOUR, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.FOUR, 0));

		int NbrOfJokers = 2;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.FOUR, true));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, true));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());
		assertTrue(h.getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == 0);
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void RoyalFlush() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.ACE, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == 0);
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void StraightFlushWilds() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.NINE, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.NINE, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.NINE, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.NINE, 0));
		Wilds.add(new Card(eSuit.CLUBS, eRank.JACK, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.JACK, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.JACK, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.JACK, 0));

		int NbrOfJokers = 1;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.SPADES, eRank.THREE, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.FIVE, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.NINE, true));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.JACK, true));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());
		assertTrue(h.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void StraightFlushJoker() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.NINE, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.NINE, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.NINE, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.NINE, 0));
		Wilds.add(new Card(eSuit.CLUBS, eRank.JACK, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.JACK, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.JACK, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.JACK, 0));

		int NbrOfJokers = 1;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.SPADES, eRank.THREE, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.JOKER, true));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.NINE, true));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.JACK, true));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());
		assertTrue(h.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void StraightFlush() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.ACE, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.THREE, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.FIVE, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void FourOfAKindWilds() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.TWO, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.TWO, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.TWO, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.TWO, 0));

		int NbrOfJokers = 3;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, true));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());

		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);
	}

	@Test
	public void FourOfAKindJoker() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.TWO, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.TWO, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.TWO, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.TWO, 0));

		int NbrOfJokers = 3;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, true));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, true));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SIX, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());

		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);

		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.SIX.getRank());

	}
	
	@Test
	public void FourOfAKind1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.KING.getRank());

	}

	@Test
	public void FourOfAKind2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.TEN.getRank());
	}

	
	@Test
	public void FullHouseWilds() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.JACK, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.JACK, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.JACK, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.JACK, 0));

		int NbrOfJokers = 2;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.JACK, true));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.KING, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());

		assertTrue(h.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == eRank.QUEEN.getRank());
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void FullHouseJoker() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.JACK, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.JACK, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.JACK, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.JACK, 0));

		int NbrOfJokers = 2;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, true));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.KING, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());

		assertTrue(h.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == eRank.QUEEN.getRank());
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void FullHouse1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.KING, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.QUEEN.getRank());
		assertTrue(h.getLowPairStrength() == eRank.KING.getRank());
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void FullHouse2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.QUEEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.QUEEN, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == eRank.QUEEN.getRank());
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void StraightWilds() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.ACE, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.ACE, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.ACE, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.ACE, 0));

		int NbrOfJokers = 2;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.ACE, true));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SEVEN, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.EIGHT, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());

		assertTrue(h.getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.JACK.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}

	@Test
	public void StraightJoker() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.THREE, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.THREE, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.THREE, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.THREE, 0));

		int NbrOfJokers = 2;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.THREE, true));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, true));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.EIGHT, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.TEN, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());

		assertTrue(h.getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.QUEEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void Straight() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.SEVEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.EIGHT, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.NINE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JACK, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.JACK.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void ThreeOfAKindWilds() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.NINE, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.NINE, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.NINE, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.NINE, 0));

		int NbrOfJokers = 1;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.SPADES, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.NINE, true));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.THREE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());

		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.JACK.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);
	}

	@Test
	public void ThreeOfAKindJoker() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.NINE, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.NINE, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.NINE, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.NINE, 0));

		int NbrOfJokers = 1;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.SPADES, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.JOKER, true));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.NINE, true));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.THREE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());

		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.JACK.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);
	}
	
	@Test
	public void ThreeOfAKind1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.THREE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.JACK.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.NINE.getRank());
		assertTrue(c2.getRank().getRank() == eRank.THREE.getRank());
	}
	
	@Test
	public void ThreeOfAKind2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.THREE, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.NINE, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.JACK.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.NINE.getRank());
		assertTrue(c2.getRank().getRank() == eRank.THREE.getRank());
	}
	
	@Test
	public void TwoPairWilds() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.FOUR, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.FOUR, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.FOUR, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.FOUR, 0));

		int NbrOfJokers = 1;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.SPADES, eRank.SEVEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.FOUR, true));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.NINE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());
		
		// If I add one wild card or more into cards in hand, the hand strength will
		// always be high than or equal to three of a kind. The hand will never be two
		// pairs when there is one wild card or more
		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.NINE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);
	}

	@Test
	public void TwoPairJoker() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.FIVE, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.FIVE, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.FIVE, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.FIVE, 0));

		int NbrOfJokers = 2;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.SPADES, eRank.SEVEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.JOKER, true));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.NINE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());
		
		// If I add one joker cards or more into cards in hand, the hand strength will
		// always be high than or equal to three of a kind. The hand will never be two
		// pairs when there is one joker card or more
		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.NINE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);
	}
	
	@Test
	public void TwoPair1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.SEVEN, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.SEVEN, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.NINE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.NINE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.NINE.getRank());
		assertTrue(h.getLowPairStrength() == eRank.SEVEN.getRank());
		assertTrue(h.getKicker().size() == 1);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.TWO.getRank());
	}
	
	@Test
	public void TwoPair2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.NINE, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.NINE, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SEVEN, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SEVEN, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.NINE.getRank());
		assertTrue(h.getLowPairStrength() == eRank.SEVEN.getRank());
		assertTrue(h.getKicker().size() == 1);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.TWO.getRank());
	}
	
	@Test
	public void PairWilds() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.KING, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.KING, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.KING, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.KING, 0));

		int NbrOfJokers = 1;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SIX, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.KING, true));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());

		assertTrue(h.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.JACK.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 3);
	}

	@Test
	public void PairJoker() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.KING, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.KING, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.KING, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.KING, 0));

		int NbrOfJokers = 2;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SIX, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JOKER, true));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());

		assertTrue(h.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.JACK.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 3);
	}
	
	@Test
	public void Pair1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.SIX, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JACK, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.JACK.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 3);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		Card c3 = h.getKicker().get(eCardNo.ThirdCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.SIX.getRank());
		assertTrue(c2.getRank().getRank() == eRank.FOUR.getRank());
		assertTrue(c3.getRank().getRank() == eRank.TWO.getRank());
	}
	
	@Test
	public void Pair2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.FOUR, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.HEARTS, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.SIX, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.JACK.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 3);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		Card c3 = h.getKicker().get(eCardNo.ThirdCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.SIX.getRank());
		assertTrue(c2.getRank().getRank() == eRank.FOUR.getRank());
		assertTrue(c3.getRank().getRank() == eRank.TWO.getRank());
	}
	
	@Test
	public void NoPairWilds() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.ACE, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.ACE, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.ACE, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.ACE, 0));

		int NbrOfJokers = 0;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.SIX, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, true));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());
		
		// If I add one wild card or more into cards in hand, the hand strength will
		// always be high than or equal to pair. The hand will never be no pair when 
		// there is one wild card or more
		assertTrue(h.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 3);
	}
	
	@Test
	public void NoPairJoker() {

		ArrayList<Card> Wilds = new ArrayList<Card>();

		Wilds.add(new Card(eSuit.CLUBS, eRank.EIGHT, 0));
		Wilds.add(new Card(eSuit.SPADES, eRank.EIGHT, 0));
		Wilds.add(new Card(eSuit.HEARTS, eRank.EIGHT, 0));
		Wilds.add(new Card(eSuit.DIAMONDS, eRank.EIGHT, 0));

		int NbrOfJokers = 0;

		Deck d = new Deck(NbrOfJokers, Wilds);
		Hand h = new Hand();

		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.SIX, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JOKER, true));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h = Hand.EvalHand(h);

		System.out.println(h.getHandStrength());
		
		// If I add one joker card or more into cards in hand, the hand strength will
		// always be high than or equal to pair. The hand will never be no pair when 
		// there is one joker card or more
		assertTrue(h.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 3);
	}

	@Test
	public void NoPair1() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.SIX, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.ACE, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.TWO, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.JACK, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.HighCard.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 4);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		Card c3 = h.getKicker().get(eCardNo.ThirdCard.getCardNo());
		Card c4 = h.getKicker().get(eCardNo.FourthCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.KING.getRank());
		assertTrue(c2.getRank().getRank() == eRank.JACK.getRank());
		assertTrue(c3.getRank().getRank() == eRank.SIX.getRank());
		assertTrue(c4.getRank().getRank() == eRank.TWO.getRank());
	}
	
	@Test
	public void NoPair2() {
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.JACK, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.KING, 0));
		h.AddCardToHand(new Card(eSuit.SPADES, eRank.ACE, 0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS, eRank.SIX, 0));
		h.AddCardToHand(new Card(eSuit.CLUBS, eRank.TWO, 0));
		h = Hand.EvalHand(h);

		assertTrue(h.getHandStrength() == eHandStrength.HighCard.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 4);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		Card c3 = h.getKicker().get(eCardNo.ThirdCard.getCardNo());
		Card c4 = h.getKicker().get(eCardNo.FourthCard.getCardNo());
		assertTrue(c1.getRank().getRank() == eRank.KING.getRank());
		assertTrue(c2.getRank().getRank() == eRank.JACK.getRank());
		assertTrue(c3.getRank().getRank() == eRank.SIX.getRank());
		assertTrue(c4.getRank().getRank() == eRank.TWO.getRank());
	}
}